package com.example.kmmplayground.presentation.detail

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

class DetailViewModel(
    private val repository: NewsRepository,
    private val dispatchers: Dispatchers
) : ViewModel(), KoinComponent {

    private val _detailState = MutableStateFlow(DetailState())
    val detailState: CStateFlow<DetailState> = _detailState.asStateFlow().cStateFlow()

    fun getNewsDetail(search: String, sources: String, page: Int) {
        viewModelScope.launch(dispatchers.io) {
            _detailState.update {
                it.copy(getNews = repository.getNewsSearch(search, sources, page))
            }
        }
    }
}