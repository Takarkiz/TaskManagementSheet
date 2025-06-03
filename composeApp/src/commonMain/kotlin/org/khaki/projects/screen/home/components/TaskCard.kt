package org.khaki.projects.screen.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun TaskCard(
    task: TaskCardUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .clip(
                RoundedCornerShape(12.dp)
            )
            .border(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                width = 1.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = {
                onClick()
            }
        )

        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(
                            shape = CircleShape
                        )
                        .background(
                            color = when (task.priority) {
                                TaskCardUiState.TaskPriority.HIGH -> MaterialTheme.colorScheme.error
                                TaskCardUiState.TaskPriority.MEDIUM -> MaterialTheme.colorScheme.primary
                                TaskCardUiState.TaskPriority.LOW -> MaterialTheme.colorScheme.secondary
                                TaskCardUiState.TaskPriority.ZERO -> MaterialTheme.colorScheme.surface
                            }
                        )
                )

                Text(
                    text = task.title,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier
                        .size(16.dp),
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "日付",
                    tint = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    text = task.date,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "優先度:",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = when (task.priority) {
                    TaskCardUiState.TaskPriority.HIGH -> "３"
                    TaskCardUiState.TaskPriority.MEDIUM -> "２"
                    TaskCardUiState.TaskPriority.LOW -> "１"
                    TaskCardUiState.TaskPriority.ZERO -> "０r"
                },
                color = when (task.priority) {
                    TaskCardUiState.TaskPriority.HIGH -> MaterialTheme.colorScheme.error
                    TaskCardUiState.TaskPriority.MEDIUM -> MaterialTheme.colorScheme.primary
                    TaskCardUiState.TaskPriority.LOW -> MaterialTheme.colorScheme.secondary
                    TaskCardUiState.TaskPriority.ZERO -> MaterialTheme.colorScheme.surface
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
private fun TaskCardPreview(
    @PreviewParameter(PreviewTaskCardUiSatePreviewProvider::class) item: TaskCardUiState
) {
    TaskCard(
        task = item,
        onClick = {

        }
    )
}

@Stable
data class TaskCardUiState(
    val title: String,
    val isCompleted: Boolean,
    val date: String,
    val priority: TaskPriority
) {

    enum class TaskPriority {
        HIGH, MEDIUM, LOW, ZERO
    }
}

internal class PreviewTaskCardUiSatePreviewProvider : PreviewParameterProvider<TaskCardUiState> {
    override val values: Sequence<TaskCardUiState>
        get() = sequenceOf(
            TaskCardUiState(
                title = "タスクタイトル",
                isCompleted = false,
                date = "今日",
                priority = TaskCardUiState.TaskPriority.HIGH
            )
        )

}
