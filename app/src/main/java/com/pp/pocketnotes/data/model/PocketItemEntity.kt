package com.pp.pocketnotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pocket")
data class PocketItemEntity(
    @PrimaryKey(autoGenerate = true) val pocketId: Int,
    val uri: String,
)