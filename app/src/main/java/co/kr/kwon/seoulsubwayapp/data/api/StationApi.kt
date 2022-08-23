package co.kr.kwon.seoulsubwayapp.data.api

import co.kr.kwon.seoulsubwayapp.data.db.entity.StationEntity
import co.kr.kwon.seoulsubwayapp.data.db.entity.SubwayEntity


interface StationApi {

    suspend fun getStationDataUpdatedTimeMillis(): Long

    suspend fun getStationSubways(): List<Pair<StationEntity, SubwayEntity>>
}