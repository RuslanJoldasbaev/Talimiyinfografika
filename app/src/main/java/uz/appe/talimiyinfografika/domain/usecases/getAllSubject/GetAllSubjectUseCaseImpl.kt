package uz.appe.talimiyinfografika.domain.usecases.getAllSubject

import uz.appe.talimiyinfografika.domain.MainRepository
import uz.appe.talimiyinfografika.domain.usecases.getAllCategory.GetAllCategoryUseCase

class GetAllSubjectUseCaseImpl(private val mainRepository: MainRepository) : GetAllSubjectUseCase {
    override suspend fun execute() = mainRepository.getAllSubject()
}