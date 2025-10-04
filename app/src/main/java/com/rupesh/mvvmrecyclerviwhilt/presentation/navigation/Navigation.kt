package com.rupesh.mvvmrecyclerviwhilt.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rupesh.mvvmrecyclerviwhilt.presentation.components.CharacterScreen
import com.rupesh.mvvmrecyclerviwhilt.presentation.viewmodel.CharactersViewModel

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CharacterScreen.route){



        composable(route = Screen.CharacterScreen.route){
            val charactersViewModel = hiltViewModel<CharactersViewModel>()
            val charactersState = charactersViewModel.charactersState.collectAsStateWithLifecycle().value
            CharacterScreen(modifier = Modifier, charactersState = charactersState)
        }

    }
}