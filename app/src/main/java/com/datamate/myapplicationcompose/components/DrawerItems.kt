package com.datamate.myapplicationcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.datamate.myapplicationcompose.R
import com.datamate.myapplicationcompose.navigation.Home
import com.datamate.myapplicationcompose.ui.theme.MyApplicationComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerItems(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    closeDrawer: ()-> Unit
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: Home.route
    ModalDrawerSheet(drawerShape = RoundedCornerShape(0.dp)) {
        DrawerHeader()
        NavigationDrawerItem(
            label = { Text(text = "Home", fontWeight = FontWeight.W600) },
            selected = currentRoute == "Home",
            onClick = {
                navController.navigate("Home"); closeDrawer()
            },
            shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            modifier = modifier
                .padding(end = 20.dp)
        )
        NavigationDrawerItem(
            label = { Text(text = "Details", fontWeight = FontWeight.W600) },
            selected = currentRoute == "Details",
            onClick = {
                navController.navigate("Details"); closeDrawer()
            },
            shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            modifier = modifier
                .padding(end = 20.dp)
        )
    }
}
@Composable
fun DrawerHeader(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_small),
            contentDescription = "null",
            modifier = modifier
                .size(88.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    MyApplicationComposeTheme() {
        DrawerItems() {
            
        }
    }
}
