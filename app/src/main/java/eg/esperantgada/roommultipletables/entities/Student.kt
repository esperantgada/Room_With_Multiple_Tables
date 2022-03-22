package eg.esperantgada.roommultipletables.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @param schoolName is the primary key of [school] table.
 * We can't put [studentName] in [school] class because a school
 * has multiple students
 */
@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName : String,

    val semester : Int,

    val schoolName : String
)
