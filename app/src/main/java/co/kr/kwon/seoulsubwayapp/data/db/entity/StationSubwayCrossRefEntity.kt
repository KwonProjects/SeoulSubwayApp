package co.kr.kwon.seoulsubwayapp.data.db.entity

import androidx.room.Entity

@Entity(primaryKeys = ["stationName", "subwayId"])
data class StationSubwayCrossRefEntity(
    val stationName: String,
    val subwayId: Int
)
