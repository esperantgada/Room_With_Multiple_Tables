package eg.esperantgada.roommultipletables.relationships

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Student

/**
 * @param students hold a list of [Student] when a [Course] is specified
 */
data class CourseAndStudent(
    @Embedded
    val course : Course,

    @Relation(
        parentColumn = "courseName",
        entityColumn = "studentName",
        associateBy = Junction(StudentAndCourseTogether::class)
    )

    val students : List<Student>
)
