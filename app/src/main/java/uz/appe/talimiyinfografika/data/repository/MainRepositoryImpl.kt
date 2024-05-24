package uz.appe.talimiyinfografika.data.repository

import uz.appe.talimiyinfografika.data.local.MainDao
import uz.appe.talimiyinfografika.domain.MainRepository
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val dao: MainDao) : MainRepository {

    override suspend fun getAllCategory() = flow {
        emit(dao.getAllCategory())
    }

    override suspend fun getAllSubject() = flow {
        emit(dao.getAllSubject())
    }

    override suspend fun getAllTasks() = flow {
        emit(dao.getAllTasks())
    }

}