package uz.appe.talimiyinfografika.di

import uz.appe.talimiyinfografika.presentation.MainViewModel
import uz.appe.talimiyinfografika.presentation.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModelImpl(
            getAllCategoryUseCase = get(),
            getAllSubjectUseCase = get(),
            getAllTasksUseCase = get()
        )
    }
}