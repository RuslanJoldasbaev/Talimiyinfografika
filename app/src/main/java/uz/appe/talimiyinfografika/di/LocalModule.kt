package uz.appe.talimiyinfografika.di

import uz.appe.talimiyinfografika.data.local.MainDao
import uz.appe.talimiyinfografika.data.local.MainDataBase
import org.koin.dsl.module

val localModule = module {
    single<MainDao> {
        get<MainDataBase>().getDao()
    }
}