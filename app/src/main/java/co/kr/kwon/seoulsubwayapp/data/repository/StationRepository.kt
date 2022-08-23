package co.kr.kwon.seoulsubwayapp.data.repository


import co.kr.kwon.seoulsubwayapp.domain.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

    val stations: Flow<List<Station>>

    suspend fun refreshStations()

}
