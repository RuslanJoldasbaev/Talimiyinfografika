package uz.appe.talimiyinfografika.domain.usecases.getAllSubject

import kotlinx.coroutines.flow.Flow
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData

interface GetAllSubjectUseCase {
    suspend fun execute(): Flow<List<SubjectData>>
}