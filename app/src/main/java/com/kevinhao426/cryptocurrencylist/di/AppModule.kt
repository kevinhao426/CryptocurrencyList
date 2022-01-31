package com.kevinhao426.cryptocurrencylist.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.kevinhao426.cryptocurrencylist.dao.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun bindContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideRoom(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "CurrencyDemoDB").build()
}