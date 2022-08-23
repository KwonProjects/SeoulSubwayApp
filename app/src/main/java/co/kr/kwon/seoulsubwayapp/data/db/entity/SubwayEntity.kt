package co.kr.kwon.seoulsubwayapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubwayEntity(
    @PrimaryKey val subwayId: Int,
)
