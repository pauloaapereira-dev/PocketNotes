package com.pp.pocketnotes.domain.pocket.repository

import com.pp.pocketnotes.domain.pocket.model.PocketItem

interface IPocketRepository {
    suspend fun getPocketItems(): List<PocketItem>
    suspend fun getPocketItemsByTag(tagId: Int): List<PocketItem>
    suspend fun savePocketItem(item: PocketItem)
}