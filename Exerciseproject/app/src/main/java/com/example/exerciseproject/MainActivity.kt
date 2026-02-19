package com.example.exerciseproject


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

import com.example.exerciseproject.routes.DetailScreenRoute
import com.example.exerciseproject.routes.HomeScreenRoute

import com.example.exerciseproject.ui.theme.ExerciseProjectTheme



class MainActivity : ComponentActivity() {

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

@Composable
fun AppNavComposable(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreenRoute) {
        composable<HomeScreenRoute> {
            HomeScreen(navController)
        }
        composable<DetailScreenRoute> { backStackEntry ->
            val detailScreenParams: DetailScreenRoute = backStackEntry.toRoute()

            DetailScreen(navController, detailScreenParams.title)
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
                        navController.navigate(DetailScreenRoute())
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    } }
            )},
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
                Row() {
                    Text("Item $index", modifier = Modifier.padding(10.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",)
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, noteInfo: String?) {
    val title = rememberTextFieldState(initialText = "Title")
    Scaffold(
        topBar = {
            TopAppBar(
                title= {Text("New Item")},
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                )},
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)){
            item {
                BasicTextField(state = title)
            }
            item{
                TextField(
                    value = noteInfo ?: "",
                    label = {Text("Title")},
                    onValueChange = {  },
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}

