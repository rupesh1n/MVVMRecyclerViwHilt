package com.rupesh.mvvmrecyclerviwhilt.data.mapper

import com.rupesh.mvvmrecyclerviwhilt.data.dto.CharactersDto
import com.rupesh.mvvmrecyclerviwhilt.domain.model.Characters

fun CharactersDto.toDomainCharacter(): Characters{
    return Characters(actor, id, image, name)
}