package co.kr.kwon.seoulsubwayapp.presentation.stations


import co.kr.kwon.seoulsubwayapp.domain.Station
import co.kr.kwon.seoulsubwayapp.presentation.BasePresenter
import co.kr.kwon.seoulsubwayapp.presentation.BaseView

interface StationsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showStations(stations: List<Station>)
    }

    interface Presenter : BasePresenter {

        fun filterStations(query: String)

    }
}