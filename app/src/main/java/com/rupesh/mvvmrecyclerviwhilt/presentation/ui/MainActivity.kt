package com.rupesh.mvvmrecyclerviwhilt.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rupesh.mvvmrecyclerviwhilt.R
import com.rupesh.mvvmrecyclerviwhilt.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Surface (
                modifier = Modifier.fillMaxSize()
            ){ Navigation() }
        }
    }
}