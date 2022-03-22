package eg.esperantgada.roommultipletables.relationships

import androidx.room.Entity

/**
 * Because it's a [n] to [n] relationship between the two tables, we created a new [Entity]
 * which takes the [Primary] keys of both [classes] as attributes and considers the combination of
 * these [primary] keys as [Primary] key
 */
@Entity(primaryKeys = ["studentName", "courseName"])
data class StudentAndCourseTogether(
    val studentName : String,
    val courseName : String
)
