package com.rupesh.mvvmrecyclerviwhilt.domain.usecase

import com.rupesh.mvvmrecyclerviwhilt.domain.reposittory.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val characterRepository: CharacterRepository) {
    operator fun invoke() = characterRepository.getAllCharacters()

}