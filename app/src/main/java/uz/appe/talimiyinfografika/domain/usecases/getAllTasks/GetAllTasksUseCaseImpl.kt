package uz.appe.talimiyinfografika.domain.usecases.getAllTasks

import uz.appe.talimiyinfografika.domain.MainRepository

class GetAllTasksUseCaseImpl(private val mainRepository: MainRepository) : GetAllTasksUseCase {
    override suspend fun execute() = mainRepository.getAllTasks()
}