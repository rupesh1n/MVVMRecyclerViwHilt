package com.rupesh.mvvmrecyclerviwhilt.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rupesh.mvvmrecyclerviwhilt.domain.model.Characters

@Composable
fun CharacterItem(modifier: Modifier = Modifier, character: Characters) { // Good practice to provide a default modifier

    // Apply the incoming modifier to the top-level Column ONLY
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            // Use a new Modifier for this inner Column
            Column(
                modifier = Modifier.fillMaxWidth(), // Don't reuse the parameter here
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = character.image,
                    contentDescription = character.name, // Good practice to use a meaningful description
                    // Use a new Modifier for the image
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp) // Set a fixed or constrained height for better layout stability
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp)), // Use a shape that matches the card
                    contentScale = ContentScale.Crop,
                )
                Text(text = character.actor, fontWeight = FontWeight.Bold)
                Text(text = character.name)
                // Use a new Modifier for the spacer
                Spacer(modifier = Modifier.height(4.dp)) // Use height for vertical spacing
            }
        }
    }
}
