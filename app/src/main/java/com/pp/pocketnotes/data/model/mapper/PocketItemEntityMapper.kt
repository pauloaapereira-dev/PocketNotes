package com.pp.pocketnotes.data.model.mapper

import com.pp.pocketnotes.data.EntityMapper
import com.pp.pocketnotes.data.model.PocketItemEntity
import com.pp.pocketnotes.domain.pocket.model.PocketItem
import javax.inject.Inject

class PocketItemEntityMapper @Inject constructor() : EntityMapper<PocketItemEntity, PocketItem> {
    override fun mapToDomain(source: PocketItemEntity): PocketItem {
        return with(source) {
            PocketItem(
                id = this.pocketId,
                uri = this.uri,
            )
        }
    }

    override fun mapFromDomain(source: PocketItem): PocketItemEntity {
        return with(source) {
            PocketItemEntity(
                pocketId = this.id,
                uri = this.uri,
            )
        }
    }
}