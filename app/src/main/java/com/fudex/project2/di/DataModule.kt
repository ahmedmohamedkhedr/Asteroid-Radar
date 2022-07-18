package com.fudex.project2.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fudex.project2.BuildConfig
import com.fudex.project2.data.dao.AppDao
import com.fudex.project2.data.local.AppDatabase
import com.fudex.project2.data.remote.ApiService
import com.fudex.project2.data.repositories.DbRepositoryImp
import com.fudex.project2.data.repositories.RemoteRepositoryImp
import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import com.fudex.project2.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBinderModule {
    @Binds
    @Singleton
    abstract fun bindRemoteRepository(imp: RemoteRepositoryImp): RemoteRepository

    @Binds
    @Singleton
    abstract fun bindDbRepository(imp: DbRepositoryImp): DbRepository
}


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteRepositoryImp(apiService: ApiService) = RemoteRepositoryImp(apiService)

    @Provides
    @Singleton
    fun provideDbRepositoryImp(dao: AppDao) = DbRepositoryImp(dao)

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, Constants.DB_NAME).build()

    @Provides
    @Singleton
    fun provideDAO(db: AppDatabase) = db.getDAO()

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}