package com.pp.pocketnotes.domain.pocket.usecases

import com.pp.pocketnotes.domain.PocketResult
import com.pp.pocketnotes.domain.pocket.model.PocketItem
import com.pp.pocketnotes.domain.pocket.repository.IPocketRepository
import com.pp.pocketnotes.domain.tags.model.Tag
import javax.inject.Inject

class GetPocketItemsByTag @Inject constructor(
    private val pocketRepository: IPocketRepository
) {

    suspend operator fun invoke(tag: Tag): PocketResult<List<PocketItem>> {
        return try {
            val pocketItems = pocketRepository.getPocketItemsByTag(tag.id)

            return PocketResult.Success(pocketItems)
        } catch (e: Exception) {
            PocketResult.Failure(e)
        }
    }
}