package eg.esperantgada.roommultipletables.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school_table")
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName : String,

    @ColumnInfo(name = "school_location")
    val schoolLocation : String
)
