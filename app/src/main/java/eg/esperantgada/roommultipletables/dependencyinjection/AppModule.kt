package eg.esperantgada.roommultipletables.dependencyinjection

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eg.esperantgada.roommultipletables.dao.AllItemsByNameDao
import eg.esperantgada.roommultipletables.dao.AllItemsDao
import eg.esperantgada.roommultipletables.dao.InsertItemDao
import eg.esperantgada.roommultipletables.dao.SortedItemsDao
import eg.esperantgada.roommultipletables.database.SchoolDatabase
import eg.esperantgada.roommultipletables.repository.AllItemsByNameRepository
import eg.esperantgada.roommultipletables.repository.AllItemsRepository
import eg.esperantgada.roommultipletables.repository.InsertItemRepository
import eg.esperantgada.roommultipletables.repository.SortedItemsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSchoolDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        SchoolDatabase::class.java,
        "school_database"
    ).fallbackToDestructiveMigration()
        .build()


    @Singleton
    @Provides
    fun provideInsertItemDao(schoolDatabase: SchoolDatabase) = schoolDatabase.getInsertItemDao()

    @Singleton
    @Provides
    fun provideAllItemsDao(schoolDatabase: SchoolDatabase) = schoolDatabase.getAllItemsDao()

    @Singleton
    @Provides
    fun provideAllItemsByNameDao(schoolDatabase: SchoolDatabase) = schoolDatabase.getAllItemsByNameDao()

    @Singleton
    @Provides
    fun provideSortedItemsDao(schoolDatabase: SchoolDatabase) = schoolDatabase.getSortedItemsDao()


    @Singleton
    @Provides
    fun provideInsertItemRepository(insertItemDao: InsertItemDao) = InsertItemRepository(insertItemDao)

    @Singleton
    @Provides
    fun provideAllItemsRepository(allItemsDao: AllItemsDao) = AllItemsRepository(allItemsDao)

    @Singleton
    @Provides
    fun provideAllItemsByNameRepository(allItemsByNameDao: AllItemsByNameDao) = AllItemsByNameRepository(allItemsByNameDao)

    @Singleton
    @Provides
    fun provideSortedItemsRepository(sortedItemsDao: SortedItemsDao) = SortedItemsRepository(sortedItemsDao)
}