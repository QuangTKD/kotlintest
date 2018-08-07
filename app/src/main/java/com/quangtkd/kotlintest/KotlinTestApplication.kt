package com.quangtkd.kotlintest

import android.app.Application
import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmConfiguration
import java.io.File

class KotlinTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("kotlinTest.realm")
                .schemaVersion(1)
//                .migration(RealmMigrations())
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
        Log.d("Realm Path", Realm.getDefaultConfiguration()?.path)

        copyRealm()
    }

    fun copyRealm(){
        val realm = Realm.getDefaultInstance()

        try {
            val file = File(Environment.getExternalStorageDirectory().path.plus("/kotlinTest.realm"))
            if (file.exists()) {

                file.delete()
            }

            realm.writeCopyTo(file)
            Toast.makeText(this, "Success export realm file", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            realm.close()
            e.printStackTrace()
        }

    }

    companion object {
        operator fun get(context: Context): KotlinTestApplication {
            return context.applicationContext as KotlinTestApplication
        }
    }

}