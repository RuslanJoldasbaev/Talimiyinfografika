package uz.appe.talimiyinfografika.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData
import uz.appe.talimiyinfografika.data.models.TasksData

@Database(entities = [CategoryData::class, SubjectData::class, TasksData::class], version = 2)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getDao(): MainDao
}