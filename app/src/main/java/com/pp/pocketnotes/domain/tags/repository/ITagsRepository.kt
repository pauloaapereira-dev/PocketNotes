package com.pp.pocketnotes.domain.tags.repository

import com.pp.pocketnotes.domain.tags.model.Tag

interface ITagsRepository {
    suspend fun getTags(): List<Tag>
}