package com.pp.pocketnotes.data.model

import androidx.room.Entity

@Entity(primaryKeys = ["pocketId", "tagId"])
data class PocketTagCrossRef(
    val pocketId: Int,
    val tagId: Int
)