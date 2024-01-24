package com.example.kmmplayground.android.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.kmmplayground.android.presentation.navgraph.NavGraph
import com.example.kmmplayground.android.presentation.navgraph.Route
import com.example.kmmplayground.android.presentation.ui.theme.NewsKmmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsKmmTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = Route.NewsNavigation.route)
                }
            }
        }
    }
}

