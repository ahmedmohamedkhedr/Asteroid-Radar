package com.fudex.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import com.fudex.project2.databinding.ActivityMainBinding
import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import com.fudex.project2.domain.use_cases.GetDataUseCase
import com.fudex.project2.presentation.services.AppWorker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

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