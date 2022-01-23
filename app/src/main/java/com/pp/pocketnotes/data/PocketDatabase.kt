package com.pp.pocketnotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pp.pocketnotes.data.pocket.PocketDao
import com.pp.pocketnotes.data.model.PocketItemEntity
import com.pp.pocketnotes.data.model.PocketTagCrossRef
import com.pp.pocketnotes.data.tags.TagsDao
import com.pp.pocketnotes.data.model.TagEntity

@Database(entities = [PocketItemEntity::class, TagEntity::class, PocketTagCrossRef::class], version = 1)
abstract class PocketDatabase : RoomDatabase() {
    abstract fun pocketDao(): PocketDao
    abstract fun tagsDao(): TagsDao
}