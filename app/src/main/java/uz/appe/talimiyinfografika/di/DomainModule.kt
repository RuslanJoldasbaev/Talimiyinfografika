package uz.appe.talimiyinfografika.di

import uz.appe.talimiyinfografika.domain.usecases.getAllCategory.GetAllCategoryUseCase
import uz.appe.talimiyinfografika.domain.usecases.getAllCategory.GetAllCategoryUseCaseImpl
import org.koin.dsl.module
import uz.appe.talimiyinfografika.domain.usecases.getAllSubject.GetAllSubjectUseCase
import uz.appe.talimiyinfografika.domain.usecases.getAllSubject.GetAllSubjectUseCaseImpl
import uz.appe.talimiyinfografika.domain.usecases.getAllTasks.GetAllTasksUseCase
import uz.appe.talimiyinfografika.domain.usecases.getAllTasks.GetAllTasksUseCaseImpl

val domainModule = module {
    factory<GetAllCategoryUseCase> {
        GetAllCategoryUseCaseImpl(mainRepository = get())
    }

    factory<GetAllSubjectUseCase> {
        GetAllSubjectUseCaseImpl(mainRepository = get())
    }

    factory<GetAllTasksUseCase> {
        GetAllTasksUseCaseImpl(mainRepository = get())
    }
}