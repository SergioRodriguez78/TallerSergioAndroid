package com.softwarejourneys.tallersergio.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.softwarejourneys.tallersergio.R
import com.softwarejourneys.tallersergio.compose.viewModel.ViewModelCompose


class composeActivity : ComponentActivity() {

    private val viewModel by viewModels<ViewModelCompose>()

    fun changeActivity() {
        val intent = Intent(this, MoviesCompose::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val textState = viewModel.userTextState.collectAsState().value
            val pwtState = viewModel.pwtTextState.collectAsState().value



            LoginScreen(
                textState, pwtState, viewModel::onTextChangeUser, viewModel::onTextChangePwt
            ) { changeActivity() }
        }
    }
}

@Composable
fun LoginScreen(
    value: String,
    valuePwt: String,
    onTextChange: (String) -> Unit,
    onTextChangePwt: (String) -> Unit,
    changeActivity: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(vertical = 200.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.baseline_supervised_user_circle_24),
            contentDescription = "Logo usuario", Modifier.size(100.dp, 100.dp)
        )
        Text(text = "Login", fontSize = 64.sp)


        TextField(
            value = value,
            onValueChange = { onTextChange(it) },
            label = { Text(text = "Ingrese el usuario") },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        TextField(
            value = valuePwt,
            onValueChange = { onTextChangePwt(it) },
            label = { Text(text = "Ingrese la contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                changeActivity()
            },
            content = { Text(text = "Ingresar") },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .height(80.dp)
                .width(280.dp)

        )


    }

}


