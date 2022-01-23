package com.pp.pocketnotes.data.pocket.di

import com.pp.pocketnotes.data.PocketDatabase
import com.pp.pocketnotes.data.pocket.PocketDao
import com.pp.pocketnotes.data.model.mapper.PocketItemEntityMapper
import com.pp.pocketnotes.data.pocket.repository.PocketRepository
import com.pp.pocketnotes.domain.pocket.repository.IPocketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PocketModule {

    @Provides
    @Singleton
    fun providePocketDao(database: PocketDatabase): PocketDao = database.pocketDao()

    @Provides
    @Singleton
    fun providePocketRepository(
        pocketDao: PocketDao,
        pocketItemEntityMapper: PocketItemEntityMapper,
    ): IPocketRepository = PocketRepository(pocketDao, pocketItemEntityMapper)
}