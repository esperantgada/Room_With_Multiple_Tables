package eg.esperantgada.roommultipletables.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.entities.Student
import eg.esperantgada.roommultipletables.relationships.StudentAndCourseTogether

@Dao
interface InsertItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentAndCourseTogether(studentAndCourseTogether: StudentAndCourseTogether)



}