package com.example.kmmplayground.presentation.home

import com.example.kmmplayground.di.Dispatchers
import com.example.kmmplayground.domain.repository.NewsRepository
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val repository: NewsRepository,
    private val dispatchers: Dispatchers
) : ViewModel(), KoinComponent {
    private val _homeState = MutableStateFlow(HomeState())
    val homeState: CStateFlow<HomeState> = _homeState.asStateFlow().cStateFlow()

    fun getNews(sources: String, page: Int) {
        viewModelScope.launch(dispatchers.io) {
            _homeState.update { state ->
                state.copy(getNews = repository.getNews(sources, page))
            }
        }
    }

}