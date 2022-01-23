package com.pp.pocketnotes.domain.pocket.usecases

import com.pp.pocketnotes.domain.PocketResult
import com.pp.pocketnotes.domain.pocket.model.PocketItem
import com.pp.pocketnotes.domain.pocket.repository.IPocketRepository
import javax.inject.Inject

class SavePocketItem @Inject constructor(
    private val pocketRepository: IPocketRepository
) {

    suspend operator fun invoke(item: PocketItem): PocketResult<Unit> {
        return try {
            return PocketResult.Success(pocketRepository.savePocketItem(item))
        } catch (e: Exception) {
            PocketResult.Failure(e)
        }
    }
}