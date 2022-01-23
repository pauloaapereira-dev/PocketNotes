package com.pp.pocketnotes.data.tags

import androidx.room.Dao
import androidx.room.Query
import com.pp.pocketnotes.data.model.TagEntity

@Dao
interface TagsDao {

    @Query("SELECT * FROM tags")
    suspend fun getAll(): List<TagEntity>

}