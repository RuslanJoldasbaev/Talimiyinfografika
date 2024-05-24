package uz.appe.talimiyinfografika.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryData(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String
)
