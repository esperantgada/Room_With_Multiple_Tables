package eg.esperantgada.roommultipletables.relationships

import androidx.room.Embedded
import androidx.room.Relation
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School

data class SchoolAndDirector(
    @Embedded
    val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)