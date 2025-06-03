package org.khaki.projects.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TodayTaskList(
    taskList: List<TaskCardUiState>,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
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
                    text = "今やるべきタスク",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }

        items(
            count = 3,
        ) {
            TaskCard(
                task = TaskCardUiState(
                    title = "タスク",
                    isCompleted = false,
                    date = "明日",
                    priority = TaskCardUiState.TaskPriority.MEDIUM
                ),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun PreviewTodayTaskList() {
    TodayTaskList(
        taskList = PreviewTaskCardUiSatePreviewProvider().values.toList()
    )
}