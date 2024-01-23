package com.example.kmmplayground.presentation.main

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

class MainViewModel(
    private val repository: NewsRepository,
    private val dispatchers: Dispatchers
) : ViewModel(), KoinComponent {

    private val _mainState = MutableStateFlow(MainState())
    val mainState: CStateFlow<MainState> = _mainState.asStateFlow().cStateFlow()

    init {
        viewModelScope.launch(dispatchers.io) {
            repository.isAlreadyOnboarding().collect { appPref ->
                _mainState.update {
                    it.copy(isOnbaordingComplete = appPref.AppEntry)
                }
            }
        }
    }
}