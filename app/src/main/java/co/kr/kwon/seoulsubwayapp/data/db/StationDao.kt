package co.kr.kwon.seoulsubwayapp.data.db

import androidx.room.*
import co.kr.kwon.seoulsubwayapp.data.db.entity.StationEntity
import co.kr.kwon.seoulsubwayapp.data.db.entity.StationSubwayCrossRefEntity
import co.kr.kwon.seoulsubwayapp.data.db.entity.StationWithSubwaysEntity
import co.kr.kwon.seoulsubwayapp.data.db.entity.SubwayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

    @Transaction
    @Query("SELECT * FROM StationEntity")
    fun getStationWithSubways(): Flow<List<StationWithSubwaysEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStations(station: List<StationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubways(subways: List<SubwayEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossReferences(reference: List<StationSubwayCrossRefEntity>)

    @Transaction
    suspend fun insertStationSubways(stationSubways: List<Pair<StationEntity, SubwayEntity>>) {
        insertStations(stationSubways.map { it.first })
        insertSubways(stationSubways.map { it.second })
        insertCrossReferences(
            stationSubways.map { (station, subway) ->
                StationSubwayCrossRefEntity(
                    station.stationName,
                    subway.subwayId
                )
            }
        )
    }
}
