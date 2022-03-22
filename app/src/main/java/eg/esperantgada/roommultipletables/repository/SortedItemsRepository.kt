package eg.esperantgada.roommultipletables.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import eg.esperantgada.roommultipletables.dao.SortedItemsDao
import javax.inject.Inject

class SortedItemsRepository @Inject constructor(private val sortedItemsDao: SortedItemsDao) {

    /**
     * Gets sorted student from the database
     */

    fun getSortedStudents(query : String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {sortedItemsDao.getSortedStudentList(query)}
    ).liveData



    /**
     * Gets sorted schools from the database
     */

    fun getSortedSchools(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {sortedItemsDao.getSortedSchoolList(query)}
    ).liveData


    /**
     * Gets sorted directors from the database
     */

    fun getSortedDirector(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {sortedItemsDao.getSortedDirectorList(query)}
    ).liveData


    /**
     * Gets sorted courses from the database
     */

    fun getSortedCourses(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {sortedItemsDao.getSortedCourseList(query)}
    ).liveData


    /**
     * Gets sorted students and courses from the database
     */

    fun getSortedStudentsAndCourses(query: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {sortedItemsDao.getSortedStudentAndCourseList(query)}
    ).liveData
}