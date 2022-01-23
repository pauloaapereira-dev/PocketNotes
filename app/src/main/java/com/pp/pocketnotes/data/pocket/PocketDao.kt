package com.pp.pocketnotes.data.pocket

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.pp.pocketnotes.data.model.PocketItemEntity
import com.pp.pocketnotes.data.model.TagWithPocketItems

@Dao
interface PocketDao {

    @Query("SELECT * FROM pocket")
    suspend fun getAll(): List<PocketItemEntity>

    @Insert
    suspend fun save(item: PocketItemEntity)

    @Transaction
    @Query("SELECT * FROM tags WHERE tagId LIKE :tagId")
    fun getAllByTag(tagId: Int): List<TagWithPocketItems>

}