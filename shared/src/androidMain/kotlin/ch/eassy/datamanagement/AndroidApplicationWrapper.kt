package ch.eassy.datamanagement

import android.app.Application

class AndroidApplicationWrapper: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var instance: AndroidApplicationWrapper
        fun instance() = instance
    }
}