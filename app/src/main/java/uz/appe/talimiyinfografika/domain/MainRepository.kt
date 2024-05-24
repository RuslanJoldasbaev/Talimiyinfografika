package uz.appe.talimiyinfografika.domain

import kotlinx.coroutines.flow.Flow
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData
import uz.appe.talimiyinfografika.data.models.TasksData

interface MainRepository {

    suspend fun getAllCategory(): Flow<List<CategoryData>>

    suspend fun getAllSubject(): Flow<List<SubjectData>>

    suspend fun getAllTasks(): Flow<List<TasksData>>

}