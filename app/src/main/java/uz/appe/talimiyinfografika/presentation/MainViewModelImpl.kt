package uz.appe.talimiyinfografika.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.appe.talimiyinfografika.domain.usecases.getAllCategory.GetAllCategoryUseCase
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData
import uz.appe.talimiyinfografika.data.models.TasksData
import uz.appe.talimiyinfografika.domain.usecases.getAllSubject.GetAllSubjectUseCase
import uz.appe.talimiyinfografika.domain.usecases.getAllTasks.GetAllTasksUseCase

class MainViewModelImpl(
    private val getAllCategoryUseCase: GetAllCategoryUseCase,
    private val getAllSubjectUseCase: GetAllSubjectUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase
) : MainViewModel() {

    override val allCategoryLiveData: LiveData<List<CategoryData>>
        get() = _allCategoryLiveData
    private val _allCategoryLiveData = MutableLiveData<List<CategoryData>>()

    override suspend fun getAllCategory() {
        getAllCategoryUseCase.execute().collect {
            _allCategoryLiveData.value = it
        }
    }

    override val allSubjectLiveData: LiveData<List<SubjectData>>
        get() = _allSubjectLiveData
    private val _allSubjectLiveData = MutableLiveData<List<SubjectData>>()

    override suspend fun getAllSubject() {
        getAllSubjectUseCase.execute().collect {
            _allSubjectLiveData.value = it
        }
    }

    override val allTasksLiveData: LiveData<List<TasksData>>
        get() = _allTasksLiveData
    private val _allTasksLiveData = MutableLiveData<List<TasksData>>()

    override suspend fun getAllTasks() {
        getAllTasksUseCase.execute().collect {
            _allTasksLiveData.value = it
        }
    }
}