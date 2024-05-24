package uz.appe.talimiyinfografika.di

import androidx.room.Room
import uz.appe.talimiyinfografika.data.local.MainDataBase
import uz.appe.talimiyinfografika.data.repository.MainRepositoryImpl
import uz.appe.talimiyinfografika.domain.MainRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<MainRepository> {
        MainRepositoryImpl(
            dao = get()
        )
    }

    single<MainDataBase> {
        Room.databaseBuilder(
            androidContext(),
            MainDataBase::class.java,
            "book.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("book.db")
            .build()
    }
}