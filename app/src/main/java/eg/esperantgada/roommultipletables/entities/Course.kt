package eg.esperantgada.roommultipletables.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class Course(
    @PrimaryKey(autoGenerate = false)
    val courseName : String,

    @ColumnInfo(name = "course_duration")
    val courseDuration : String
)
