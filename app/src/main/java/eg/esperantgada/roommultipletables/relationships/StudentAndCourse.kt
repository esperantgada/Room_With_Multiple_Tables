package eg.esperantgada.roommultipletables.relationships

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Student

/**
 * @param courses holds a list of [Course] for a [Student] when this one is specified
 */
data class StudentAndCourse(
    @Embedded
    val student : Student,

    @Relation(parentColumn = "studentName", entityColumn = "courseName", associateBy = Junction(StudentAndCourseTogether::class))
    val courses : List<Course>
)
