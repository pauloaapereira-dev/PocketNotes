package com.pp.pocketnotes.data.tags.repository

import com.pp.pocketnotes.data.tags.TagsDao
import com.pp.pocketnotes.data.model.mapper.TagEntityMapper
import com.pp.pocketnotes.domain.tags.model.Tag
import com.pp.pocketnotes.domain.tags.repository.ITagsRepository
import javax.inject.Inject

class TagsRepository @Inject constructor(
    private val tagsDao: TagsDao,
    private val tagEntityMapper: TagEntityMapper,
) : ITagsRepository {
    override suspend fun getTags(): List<Tag> {
        return tagsDao.getAll().map { tagEntityMapper.mapToDomain(it) }
    }
}