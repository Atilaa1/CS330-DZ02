package rs.ac.metropolitan.cs330_dz02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rs.ac.metropolitan.cs330_dz02.ui.theme.CS330DZ02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CS330DZ02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var bmi by remember { mutableStateOf("") }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "BMI kalkulator", style = MaterialTheme.typography.headlineLarge
            )
        })
    }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            TextField(
                value = height,
                onValueChange = { height = it },
                label = { Text(text = "Unesite visinu") }
            )
            TextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text(text = "Unesite težinu") }
            )
            Button(onClick = {
                val heightMeters = height.toFloat() / 100
                val weightKg = weight.toFloat()
                bmi = (weightKg / (heightMeters * heightMeters)).toString()
            }) {
                Text("Izračunaj")
            }
            Text(text = "BMI: $bmi")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CS330DZ02Theme {
        MainView()
    }
}