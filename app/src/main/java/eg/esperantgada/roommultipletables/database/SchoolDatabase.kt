package eg.esperantgada.roommultipletables.database

import androidx.room.Database
import androidx.room.RoomDatabase
import eg.esperantgada.roommultipletables.dao.*
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.entities.Student
import eg.esperantgada.roommultipletables.relationships.StudentAndCourseTogether

@Database(
    entities = [
        School::class,
        Director::class,
        Student::class,
        Course::class,
        StudentAndCourseTogether::class
    ], version = 1, exportSchema = false
)
abstract class SchoolDatabase : RoomDatabase(){

    abstract fun getInsertItemDao() : InsertItemDao

    abstract fun getAllItemsByNameDao() : AllItemsByNameDao

    abstract fun getAllItemsDao() : AllItemsDao

    abstract fun getSortedItemsDao() : SortedItemsDao
}