package fr.ap7.mastermind

import android.app.Application
import fr.ap7.mastermind.data.repositoryModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Allow to inject dependencies
        startKoin(this, listOf(repositoryModule))

        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant()
        }
        Timber.tag("MasterMind Test")
    }
}