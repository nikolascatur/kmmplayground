package com.example.kmmplayground.android.presentation.navgraph

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val argument: List<NamedNavArgument> = emptyList()
) {
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")
    object HomeScreen : Route("homeScreen")
    object DetailScreen : Route("detailScreen")
    object SearchScreen : Route("searchScreen")
    object SaveScreen : Route("saveScreen")
}
