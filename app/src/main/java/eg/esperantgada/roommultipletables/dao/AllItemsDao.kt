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
interface AllItemsDao {
    @Query("SELECT * FROM school_table ORDER BY schoolName AND school_location")
    fun getAllSchools() : PagingSource<Int, School>


    @Query("SELECT * FROM director_table ORDER BY directorName AND schoolName")
    fun getAllDirectors() : PagingSource<Int, Director>

    @Query("SELECT * FROM course_table ORDER BY courseName and course_duration")
    fun getAllCourses() : PagingSource<Int, Course>


    @Query("SELECT * FROM student_table ORDER BY studentName")
    fun getAllStudents() : PagingSource<Int, Student>


    @Query("SELECT * FROM studentandcoursetogether ORDER BY studentName AND courseName")
    fun getAllStudentsAndCourses() : PagingSource<Int, StudentAndCourseTogether>

}