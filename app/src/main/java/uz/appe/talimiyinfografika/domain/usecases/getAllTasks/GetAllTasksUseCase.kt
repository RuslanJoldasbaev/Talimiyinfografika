package uz.appe.talimiyinfografika.domain.usecases.getAllTasks

import kotlinx.coroutines.flow.Flow
import uz.appe.talimiyinfografika.data.models.TasksData

interface GetAllTasksUseCase {
    suspend fun execute(): Flow<List<TasksData>>
}