package eg.esperantgada.roommultipletables.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import eg.esperantgada.roommultipletables.dao.AllItemsByNameDao
import javax.inject.Inject

class AllItemsByNameRepository @Inject constructor(private val allItemsByNameDao: AllItemsByNameDao) {

    /**
     * Gets school and its director name when entering the name of the school
     */
    fun getDirectorBySchoolName(schoolName : String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {allItemsByNameDao.getAllDirectorsBySchoolName(schoolName)}
    ).liveData


    /**
     * Retrieves all students in a school after passing in the school Name as argument
     */
    /*fun getAllStudentsBySchoolName(schoolName: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {schoolDao.getAllStudentsBySchoolName(schoolName)}
    ).liveData*/

    val allStudentsBySchoolName = allItemsByNameDao.getAllStudentsBySchoolName(schoolName = "IFRI")


    /**
     * Gets the list all students who are following a specific course
     */
    /*fun getAllStudentsByCourseName(courseName : String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {schoolDao.getAllStudentsByCourseName(courseName)}
    ).liveData*/

    val allStudentsByCourseName = allItemsByNameDao.getAllStudentsByCourseName(courseName = "Android")


    /**
     * Retrieves the list of all courses taken by a specific student with his name
     */
    /*fun getAllCoursesByStudentName(studentName : String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {schoolDao.getAllCoursesByStudentName(studentName)}
    ).liveData
*/
    val allCourseByStudentName = allItemsByNameDao.getAllCoursesByStudentName(studentName = "Esperant")

}