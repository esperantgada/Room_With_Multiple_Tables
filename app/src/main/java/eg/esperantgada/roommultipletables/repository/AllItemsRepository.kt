package eg.esperantgada.roommultipletables.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import eg.esperantgada.roommultipletables.dao.AllItemsDao
import javax.inject.Inject

class AllItemsRepository @Inject constructor(private val allItemsDao: AllItemsDao) {

    /**
     * Gets all student from the database
     */

    fun getAllStudents() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {allItemsDao.getAllStudents()}
    ).flow



    /**
     * Gets all schools from the database
     */

    fun getAllSchools() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {allItemsDao.getAllSchools()}
    ).flow


    /**
     * Gets all directors from the database
     */

    fun getAllDirector() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {allItemsDao.getAllDirectors()}
    ).flow


    /**
     * Gets all courses from the database
     */

    fun getAllCourses() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {allItemsDao.getAllCourses()}
    ).flow


    /**
     * Gets all students and courses from the database
     */

    fun getAllStudentsAndCourses() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {allItemsDao.getAllStudentsAndCourses()}
    ).flow


}