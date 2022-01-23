package com.pp.pocketnotes.domain.pocket.usecases

import com.pp.pocketnotes.domain.PocketResult
import com.pp.pocketnotes.domain.pocket.model.PocketItem
import com.pp.pocketnotes.domain.pocket.repository.IPocketRepository
import javax.inject.Inject

class GetPocketItems @Inject constructor(
    private val pocketRepository: IPocketRepository
) {

    suspend operator fun invoke(): PocketResult<List<PocketItem>> {
        return try {
            PocketResult.Success(pocketRepository.getPocketItems())
        } catch (e: Exception) {
            PocketResult.Failure(e)
        }
    }
}