package fr.ap7.mastermind

import android.app.Application
import timber.log.Timber

/**
 * Initialize timber log & set in debug mode only.
 *
 * @author ap7
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant()
        }
        Timber.tag("MasterMind Test")
    }
}