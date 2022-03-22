package eg.esperantgada.roommultipletables.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.relationships.CourseAndStudent
import eg.esperantgada.roommultipletables.relationships.SchoolAndDirector
import eg.esperantgada.roommultipletables.relationships.SchoolAndStudent
import eg.esperantgada.roommultipletables.relationships.StudentAndCourse
import kotlinx.coroutines.flow.Flow

@Dao
interface AllItemsByNameDao {

    @Transaction
    @Query("SELECT * FROM course_table WHERE courseName = :courseName")
    fun getAllStudentsByCourseName(courseName : String) : Flow<List<CourseAndStudent>>

    @Transaction
    @Query("SELECT * FROM student_table WHERE studentName = :studentName")
    fun getAllCoursesByStudentName(studentName: String) : Flow<List<StudentAndCourse>>

    /**
     * Gets [School] with associated [Director] when [schoolName] is provided
     */
    @Transaction
    @Query("SELECT * FROM school_table WHERE schoolName = :schoolName")
    fun getAllDirectorsBySchoolName(schoolName: String) : PagingSource<Int, SchoolAndDirector>



    /**
     * Gets all students when the name of a school is specified
     */
    @Transaction
    @Query("SELECT * FROM school_table WHERE schoolName = :schoolName")
    fun getAllStudentsBySchoolName(schoolName: String) : Flow<List<SchoolAndStudent>>


}