package uz.appe.talimiyinfografika.domain.usecases.getAllCategory

import kotlinx.coroutines.flow.Flow
import uz.appe.talimiyinfografika.data.models.CategoryData

interface GetAllCategoryUseCase {
    suspend fun execute(): Flow<List<CategoryData>>
}