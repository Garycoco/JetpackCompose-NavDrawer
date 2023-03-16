package com.datamate.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.rememberDrawerState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.datamate.myapplicationcompose.components.DetailsPage
import com.datamate.myapplicationcompose.components.DrawerItems
import com.datamate.myapplicationcompose.components.HomePage
import com.datamate.myapplicationcompose.navigation.Details
import com.datamate.myapplicationcompose.navigation.Home
import com.datamate.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                MyApplication()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApplication(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = { DrawerItems(navController = navController, closeDrawer = { scope.launch { drawerState.close() } }) },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "My Application") },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { drawerState.apply { if (isClosed) open() else close() } } }
                        ) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) {
            Box(
                modifier = modifier
                    .padding(it)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Home.route
                ) {
                    composable(Home.route) {
                        HomePage()
                    }
                    composable(Details.route) {
                        DetailsPage()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationComposeTheme {

    }
}