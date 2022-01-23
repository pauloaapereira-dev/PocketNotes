package com.pp.pocketnotes.data.pocket.repository

import com.pp.pocketnotes.data.model.mapper.PocketItemEntityMapper
import com.pp.pocketnotes.data.pocket.PocketDao
import com.pp.pocketnotes.domain.pocket.model.PocketItem
import com.pp.pocketnotes.domain.pocket.repository.IPocketRepository
import javax.inject.Inject

class PocketRepository @Inject constructor(
    private val pocketDao: PocketDao,
    private val pocketItemEntityMapper: PocketItemEntityMapper,
) : IPocketRepository {
    override suspend fun getPocketItems(): List<PocketItem> {
        return pocketDao.getAll().map { pocketItemEntityMapper.mapToDomain(it) }
    }

    override suspend fun getPocketItemsByTag(tagId: Int): List<PocketItem> {
        return pocketDao.getAllByTag(tagId).firstOrNull()?.pocketItems?.map { pocketItemEntityMapper.mapToDomain(it) }.orEmpty()
    }

    override suspend fun savePocketItem(item: PocketItem) {
        pocketDao.save(pocketItemEntityMapper.mapFromDomain(item))
    }
}