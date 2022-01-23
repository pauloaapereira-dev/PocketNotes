package com.pp.pocketnotes.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TagWithPocketItems(
    @Embedded val tag: TagEntity,
    @Relation(
        parentColumn = "tagId",
        entityColumn = "pocketId",
        associateBy = Junction(PocketTagCrossRef::class)
    )
    val pocketItems: List<PocketItemEntity>
)