package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme{
                    LemonApp()
                }
            }
        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp(){

    var PasoActual by remember { mutableStateOf(1)  }

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "LIMONADA",
                    fontWeight = FontWeight.Bold
                )
            },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when(PasoActual){
                1 ->{
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(text = stringResource(R.string.contenido_arbol))
                        Spacer(modifier = Modifier.height(32.dp))
                        Image(painter = painterResource(R.drawable.lemon_tree) ,
                            contentDescription = stringResource(R.string.descripcion_arbol),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    PasoActual = 2
                                }
                        )
                    }
                }
                2 ->{
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(text = stringResource(R.string.contenido_exprimir))
                        Spacer(modifier = Modifier.height(32.dp))
                        Image(painter = painterResource(R.drawable.lemon_squeeze) ,
                            contentDescription = stringResource(R.string.descripcion_exprimir),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    PasoActual = 3
                                }
                        )
                    }
                }
                3 ->{
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(text = stringResource(R.string.contenido_limonada))
                        Spacer(modifier = Modifier.height(32.dp))
                        Image(painter = painterResource(R.drawable.lemon_drink) ,
                            contentDescription = stringResource(R.string.descripcion_limonada),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    PasoActual = 4
                                }
                        )
                    }
                }

                4 ->{
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(text = stringResource(R.string.contenido_vaso))
                        Spacer(modifier = Modifier.height(32.dp))
                        Image(painter = painterResource(R.drawable.lemon_restart) ,
                            contentDescription = stringResource(R.string.descripcion_vaso),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    PasoActual = 1
                                }
                        )
                    }
                }

            }

    }

    }
}

@Composable
fun WelcomeScreen(name: String, onStartClicked: () -> Unit) {
    Column {
        Text(text = "Welcome $name!")
        Button(
            onClick = onStartClicked)
        {
            Text("Start")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonApp()
    }
}

