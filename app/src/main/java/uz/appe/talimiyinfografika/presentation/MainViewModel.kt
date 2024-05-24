package uz.appe.talimiyinfografika.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData
import uz.appe.talimiyinfografika.data.models.TasksData

abstract class MainViewModel : ViewModel() {

    abstract val allCategoryLiveData: LiveData<List<CategoryData>>
    abstract suspend fun getAllCategory()

    abstract val allSubjectLiveData: LiveData<List<SubjectData>>
    abstract suspend fun getAllSubject()

    abstract val allTasksLiveData: LiveData<List<TasksData>>
    abstract suspend fun getAllTasks()
}