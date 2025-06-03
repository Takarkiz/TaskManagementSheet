package org.khaki.projects.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.khaki.projects.screen.home.components.TodayTaskList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigationItem: HomeTab = HomeTab.TODAY,
    uiState: TodayTaskListUiState,
    onClickNavigationItem: (HomeTab) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            ),
        topBar = {
            TopAppBar(
                title = {

                    Column {
                        Text(
                            text = navigationItem.label,
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "N件のタスク",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            when (uiState) {


                TodayTaskListUiState.Empty -> {

                }

                TodayTaskListUiState.Loading -> {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                is TodayTaskListUiState.Success -> {
                    TodayTaskList(
                        modifier = Modifier
                            .fillMaxWidth(),
                        taskList = uiState.taskList
                    )
                }

                is TodayTaskListUiState.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "取得に失敗しました",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        uiState = TodayTaskListUiState.Empty,
        onClickNavigationItem = {},
    )
}
