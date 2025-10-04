package com.rupesh.mvvmrecyclerviwhilt.data.api

import com.rupesh.mvvmrecyclerviwhilt.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getAllCharacters(): List<CharactersDto>
}