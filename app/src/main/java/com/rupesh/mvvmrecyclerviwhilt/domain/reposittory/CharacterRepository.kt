package com.rupesh.mvvmrecyclerviwhilt.domain.reposittory

import com.rupesh.mvvmrecyclerviwhilt.core.common.Resource
import com.rupesh.mvvmrecyclerviwhilt.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun  getAllCharacters() : Flow<Resource<List<Characters>>>
}