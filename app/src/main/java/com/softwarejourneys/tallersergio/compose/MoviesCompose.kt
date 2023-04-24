package com.softwarejourneys.tallersergio.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.softwarejourneys.tallersergio.compose.viewModel.ViewModelCompose
import com.softwarejourneys.tallersergio.ui.movies.model.Movie


class MoviesCompose : ComponentActivity() {
    private val viewModel by viewModels<ViewModelCompose>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            lista(viewModel.movies())
        }
    }

}

@Composable
fun lista(movies: List<Movie>) {
Column( modifier = Modifier.padding(9.dp) ) {

    Row() {
        Button(
            onClick = {

            },
            content = { Text(text = "Movies") },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .height(80.dp)
                .width(190.dp)

        )
        Button(
            onClick = {
            },
            content = { Text(text = "Favoritas") },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .height(80.dp)
                .width(190.dp)

        )
    }

    Row() {

        Text(
            text = "Id",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "imagen",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "nombre",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "duracion",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "favorito",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

    }
    LazyColumn(
        modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center
    ) {

        items(movies) {

                movie ->
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movie.id.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                AsyncImage(
                    model = movie.ImageUrl,
                    contentDescription = "imagen pelicula",
                    modifier = Modifier.size(100.dp, 100.dp)
                )

                Text(
                    text = movie.name,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = movie.duration.toString(),

                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                androidx.compose.material.Checkbox(
                    checked = false,
                    onCheckedChange = { true },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.White,
                        uncheckedColor = Color.White
                    )
                )

            }

        }
    }
}
}