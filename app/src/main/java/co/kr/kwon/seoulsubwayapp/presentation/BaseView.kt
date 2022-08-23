package co.kr.kwon.seoulsubwayapp.presentation

interface BaseView<PresenterT : BasePresenter> {
    val presenter : PresenterT
}