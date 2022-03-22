package eg.esperantgada.roommultipletables.relationships

import androidx.room.Embedded
import androidx.room.Relation
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.entities.Student

data class SchoolAndStudent(
    @Embedded
    val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
