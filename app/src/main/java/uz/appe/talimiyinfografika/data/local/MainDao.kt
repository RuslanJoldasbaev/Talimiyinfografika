package uz.appe.talimiyinfografika.data.local

import androidx.room.Dao
import androidx.room.Query
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData
import uz.appe.talimiyinfografika.data.models.TasksData

@Dao
interface MainDao {

    @Query("SELECT * FROM category")
    suspend fun getAllCategory(): List<CategoryData>

    @Query("SELECT * FROM subject")
    suspend fun getAllSubject(): List<SubjectData>

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<TasksData>
}