package uz.appe.talimiyinfografika.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject")
data class SubjectData(
    @PrimaryKey val id: Int,
    val name: String
)
