package com.pp.pocketnotes.domain.tags.usecases

import com.pp.pocketnotes.domain.PocketResult
import com.pp.pocketnotes.domain.tags.model.Tag
import com.pp.pocketnotes.domain.tags.repository.ITagsRepository
import javax.inject.Inject

class GetTags @Inject constructor(
    private val tagsRepository: ITagsRepository
) {

    suspend operator fun invoke(): PocketResult<List<Tag>> {
        return try {
            return PocketResult.Success(tagsRepository.getTags())
        } catch (e: Exception) {
            PocketResult.Failure(e)
        }
    }
}