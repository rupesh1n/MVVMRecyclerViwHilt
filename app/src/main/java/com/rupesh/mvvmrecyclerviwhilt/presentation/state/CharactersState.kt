package com.rupesh.mvvmrecyclerviwhilt.presentation.state

import com.rupesh.mvvmrecyclerviwhilt.domain.model.Characters

data class CharactersState(
    val isLoading: Boolean = false,
    val characters: List<Characters> ?= emptyList(),
    val error: String? = ""
)
