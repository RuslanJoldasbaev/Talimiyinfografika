package uz.appe.talimiyinfografika.app

import android.app.Application
import uz.appe.talimiyinfografika.di.appModule
import uz.appe.talimiyinfografika.di.dataModule
import uz.appe.talimiyinfografika.di.domainModule
import uz.appe.talimiyinfografika.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, dataModule, domainModule, localModule))
            androidContext(this@App)
        }
    }
}