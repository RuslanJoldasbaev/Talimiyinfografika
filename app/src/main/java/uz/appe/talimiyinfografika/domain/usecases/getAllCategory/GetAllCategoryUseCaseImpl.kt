package uz.appe.talimiyinfografika.domain.usecases.getAllCategory

import uz.appe.talimiyinfografika.domain.MainRepository
import uz.appe.talimiyinfografika.domain.usecases.getAllCategory.GetAllCategoryUseCase

class GetAllCategoryUseCaseImpl(private val mainRepository: MainRepository) : GetAllCategoryUseCase {
    override suspend fun execute() = mainRepository.getAllCategory()
}