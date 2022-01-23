package com.pp.pocketnotes.data.di

import android.content.Context
import androidx.room.Room
import com.pp.pocketnotes.data.PocketDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providePocketDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PocketDatabase::class.java, "pocket-database"
    ).build()
}