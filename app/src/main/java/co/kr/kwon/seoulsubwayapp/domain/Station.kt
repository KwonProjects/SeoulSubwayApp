package co.kr.kwon.seoulsubwayapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Station(
    val name: String,
    val isFavorited: Boolean,
    val connectedSubways: List<Subway>
) : Parcelable
