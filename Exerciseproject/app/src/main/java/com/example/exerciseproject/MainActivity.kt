package com.example.exerciseproject

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exerciseproject.ui.theme.ExerciseProjectTheme


class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExerciseProjectTheme {
                AppNavComposable()
            }
        }
    }
}

sealed class Screen(val route: String){
    object Home: Screen("home")
    object AddItem: Screen("add_item")
}


@Composable
fun AppNavComposable(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.AddItem.route) {
            AddItemScreen(navController)
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title= {Text("Block Note")},
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.AddItem.route)
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    } })},
    ) { innerPadding ->
        ListOfItems(
            name = "Android",
            modifier = Modifier.padding(innerPadding),
            items = listOf("")
        )
    }
}


@Composable
fun ListOfItems(name: String, modifier: Modifier = Modifier, items: List<String>) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(7){ index ->
            Card(
                border = BorderStroke(width = 1.dp,Color.Black ),
                modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp)) {
                Text("Item $index", modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title= {Text("New Item")},
                )},
    ) { innerPadding ->
        Text("Android",
            modifier = Modifier.padding(innerPadding),

        )
    }

}

