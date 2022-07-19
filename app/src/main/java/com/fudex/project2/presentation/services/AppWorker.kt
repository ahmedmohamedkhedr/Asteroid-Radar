package com.fudex.project2.presentation.services

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class AppWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val remoteRepository: RemoteRepository,
    private val dbRepository: DbRepository
) : CoroutineWorker(
    appContext,
    params
) {

    override suspend fun doWork(): Result {
        return try {
            dbRepository.clearAll()
            val dataFromServer = withContext(Dispatchers.IO) { remoteRepository.getData() }
            dataFromServer.nearEarthObjects?.values?.forEach { list ->
                dbRepository.addData(list.map { it.toEntityModel() }.toMutableList())
            }
            Result.success()
        } catch (e: Exception) {
            print(e.message)
            Result.failure()
        }
    }
}