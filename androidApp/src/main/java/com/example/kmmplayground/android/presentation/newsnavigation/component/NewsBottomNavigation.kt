package com.example.kmmplayground.android.presentation.newsnavigation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigation>,
    selectedItem: Int,
    onClickItem: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, bottomNavigation ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onClickItem(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = bottomNavigation.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = bottomNavigation.title,
                            style = MaterialTheme.typography.bodySmall
                        )

                    }
                }
            )
        }
    }
}

data class BottomNavigation(
    @DrawableRes val icon: Int,
    val title: String
)