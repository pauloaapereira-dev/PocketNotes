package com.pp.pocketnotes.data.tags.di

import com.pp.pocketnotes.data.PocketDatabase
import com.pp.pocketnotes.data.tags.TagsDao
import com.pp.pocketnotes.data.model.mapper.TagEntityMapper
import com.pp.pocketnotes.data.tags.repository.TagsRepository
import com.pp.pocketnotes.domain.tags.repository.ITagsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TagsModule {

    @Provides
    @Singleton
    fun provideTagsDao(database: PocketDatabase): TagsDao = database.tagsDao()

    @Provides
    @Singleton
    fun provideTagsRepository(
        tagsDao: TagsDao,
        tagEntityMapper: TagEntityMapper,
    ): ITagsRepository = TagsRepository(tagsDao, tagEntityMapper)
}