package com.example.kmmplayground.android.presentation.newsnavigation


import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kmmplayground.SharedRes
import com.example.kmmplayground.android.presentation.navgraph.Route
import com.example.kmmplayground.android.presentation.newsnavigation.component.BottomNavigation
import com.example.kmmplayground.android.presentation.newsnavigation.component.NewsBottomNavigation

@Composable
fun NewsNavigator(context: Context) {

    val bottomNavigation = remember {
        listOf(
            BottomNavigation(
                icon = SharedRes.images.ic_home.drawableResId,
                title = context.getString(SharedRes.strings.home.resourceId)
            ),
            BottomNavigation(
                icon = SharedRes.images.ic_save.drawableResId,
                title = context.getString(SharedRes.strings.bookmark.resourceId)
            )
        )
    }
    val navController = rememberNavController()
    var selectItem by rememberSaveable {
        mutableStateOf(0)
    }
    val backStackState = navController.currentBackStackEntryAsState().value

    selectItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SaveScreen.route -> 1
        else -> 0
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NewsBottomNavigation(
                items = bottomNavigation,
                selectedItem = selectItem,
                onClickItem = { index ->
                    when (index) {
                        0 -> navigateToTab(navController, Route.HomeScreen.route)
                        1 -> navigateToTab(navController, Route.SaveScreen.route)
                    }

                })
        }
    )
    {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(Route.HomeScreen.route) {

            }
            composable(Route.SaveScreen.route) {

            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screenRoute ->
            popUpTo(screenRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

}