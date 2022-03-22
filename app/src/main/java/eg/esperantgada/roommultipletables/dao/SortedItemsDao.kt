package eg.esperantgada.roommultipletables.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.entities.Student
import eg.esperantgada.roommultipletables.relationships.StudentAndCourseTogether

@Dao
interface SortedItemsDao {

    @Query("SELECT * FROM course_table WHERE courseName LIKE '%' || :query || '%' ORDER BY courseName")
    fun getSortedCourseList(query : String) : PagingSource<Int, Course>

    @Query("SELECT * FROM school_table WHERE schoolName LIKE '%' || :query || '%' ORDER BY schoolName")
    fun getSortedSchoolList(query: String) : PagingSource<Int, School>

    @Query("SELECT * FROM director_table WHERE directorName LIKE '%' || :query || '%' ORDER BY directorName")
    fun getSortedDirectorList(query: String) : PagingSource<Int, Director>

    @Query("SELECT * FROM student_table WHERE studentName LIKE '%' || :query || '%' ORDER BY studentName")
    fun getSortedStudentList(query: String) : PagingSource<Int, Student>

    @Query("SELECT * FROM studentandcoursetogether WHERE studentName OR courseName LIKE '%' || :query || '%' ORDER BY studentName AND courseName")
    fun getSortedStudentAndCourseList(query: String) : PagingSource<Int, StudentAndCourseTogether>

}