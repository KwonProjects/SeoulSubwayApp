package co.kr.kwon.seoulsubwayapp.data.db.entity.mapper

import co.kr.kwon.seoulsubwayapp.data.db.entity.StationEntity
import co.kr.kwon.seoulsubwayapp.data.db.entity.StationWithSubwaysEntity
import co.kr.kwon.seoulsubwayapp.data.db.entity.SubwayEntity
import co.kr.kwon.seoulsubwayapp.domain.Station
import co.kr.kwon.seoulsubwayapp.domain.Subway


fun StationWithSubwaysEntity.toStation() =
    Station(
        name = station.stationName,
        isFavorited = station.isFavorited,
        connectedSubways = subways.toSubways()
    )

fun Station.toStationEntity() =
    StationEntity(
        stationName = name,
        isFavorited = isFavorited,
    )


fun List<StationWithSubwaysEntity>.toStations() = map { it.toStation() }

fun List<SubwayEntity>.toSubways(): List<Subway> = map { Subway.findById(it.subwayId) }
