package org.khaki.projects.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigationItem: HomeTab = HomeTab.TODAY,
    onClickNavigationItem: (HomeTab) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = navigationItem.label
                    )
                },
            )
        },
        bottomBar = {
            NavigationBar {

                HomeTab.entries.forEach { item ->
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            onClickNavigationItem(item)
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                ) {
                    Text(
                        text = "今日やること",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

            items(
                count = 3,
            ) {
                TaskCard(
                    title = "Task $it"
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        onClickNavigationItem = {},
    )
}
