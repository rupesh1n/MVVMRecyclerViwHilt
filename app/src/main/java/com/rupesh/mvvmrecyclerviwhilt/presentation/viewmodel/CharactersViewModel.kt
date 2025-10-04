package com.rupesh.mvvmrecyclerviwhilt.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rupesh.mvvmrecyclerviwhilt.core.common.Resource
import com.rupesh.mvvmrecyclerviwhilt.domain.usecase.GetAllCharacterUseCase
import com.rupesh.mvvmrecyclerviwhilt.presentation.state.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetAllCharacterUseCase) : ViewModel() {

    private val _charactersState = MutableStateFlow(CharactersState())
    val charactersState: StateFlow<CharactersState>
        get() =_charactersState


    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        useCase().onEach {
                when (it) {
                    is Resource.Loading -> {
                        _charactersState.value = CharactersState().copy(isLoading = true)
                    }
                    is Resource.Error-> {
                        _charactersState.value = CharactersState().copy(error = it.msg)
                    }
                    is Resource.Success -> {
                        _charactersState.value = CharactersState().copy(characters = it.data)
                    }
                }
        }.launchIn(viewModelScope)
    }
}