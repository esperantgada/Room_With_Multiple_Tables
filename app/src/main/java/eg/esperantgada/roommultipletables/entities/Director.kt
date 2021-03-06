package eg.esperantgada.roommultipletables.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "director_table")
data class Director(
    @PrimaryKey(autoGenerate = false)
    val directorName : String,

    val schoolName : String
)
