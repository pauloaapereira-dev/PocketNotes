package com.pp.pocketnotes.data.model.mapper

import com.pp.pocketnotes.data.EntityMapper
import com.pp.pocketnotes.data.model.TagEntity
import com.pp.pocketnotes.domain.tags.model.Tag
import javax.inject.Inject

class TagEntityMapper @Inject constructor() : EntityMapper<TagEntity, Tag> {
    override fun mapToDomain(source: TagEntity): Tag {
        return with(source) {
            Tag(
                id = this.tagId,
                title = this.title,
            )
        }
    }

    override fun mapFromDomain(source: Tag): TagEntity {
        return with(source) {
            TagEntity(
                tagId = this.id,
                title = this.title,
            )
        }
    }
}