package uz.appe.talimiyinfografika.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TasksData(
    @PrimaryKey val id: Int,
    val name: String
)
