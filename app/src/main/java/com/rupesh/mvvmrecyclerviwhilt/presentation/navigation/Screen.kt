package com.rupesh.mvvmrecyclerviwhilt.presentation.navigation

sealed class Screen (val route: String){
    object  CharacterScreen : Screen("character_screen")
}