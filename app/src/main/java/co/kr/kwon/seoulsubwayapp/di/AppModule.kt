package co.kr.kwon.seoulsubwayapp.di

import android.app.Activity
import co.kr.kwon.seoulsubwayapp.data.api.StationApi
import co.kr.kwon.seoulsubwayapp.data.api.StationStorageApi
import co.kr.kwon.seoulsubwayapp.data.db.AppDatabase
import co.kr.kwon.seoulsubwayapp.data.preference.PreferenceManager
import co.kr.kwon.seoulsubwayapp.data.preference.SharedPreferenceManager
import co.kr.kwon.seoulsubwayapp.data.repository.StationRepository
import co.kr.kwon.seoulsubwayapp.data.repository.StationRepositoryImpl
import co.kr.kwon.seoulsubwayapp.presentation.stations.StationsContract
import co.kr.kwon.seoulsubwayapp.presentation.stations.StationsFragment
import co.kr.kwon.seoulsubwayapp.presentation.stations.StationsPresenter
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { Dispatchers.IO }

    //Database
    single { AppDatabase.build(androidApplication()) }
    single { get<AppDatabase>().stationDao() }

    //Preference
    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get()) }

    //Api
    single<StationApi> { StationStorageApi(Firebase.storage) }

    //Repository
    single<StationRepository> { StationRepositoryImpl(get(), get(), get(), get()) }

    //Presentation
    scope<StationsFragment> {
        scoped<StationsContract.Presenter> { StationsPresenter(get(), get()) }
    }

}