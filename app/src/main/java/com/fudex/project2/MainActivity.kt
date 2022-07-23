package com.fudex.project2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.fudex.project2.databinding.ActivityMainBinding
import com.fudex.project2.presentation.services.AppWorker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val workRequest: WorkRequest =
        OneTimeWorkRequestBuilder<AppWorker>()
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresCharging(true)
                    .build()
            )
            .build()

    private val workManager: WorkManager by lazy {
        WorkManager.getInstance(this)
    }


    private val ui: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)
        workManager.enqueue(workRequest)
    }

}