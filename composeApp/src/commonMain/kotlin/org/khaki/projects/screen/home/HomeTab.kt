package org.khaki.projects.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeTab(
    val label: String,
    val icon: ImageVector,
) {

    TODAY("今日やること", Icons.Default.Flag),

    SCHEDULE("スケジュール", Icons.Default.Schedule),

//    ANALYTICS("分析", Icons.Default.Analytics),

    REVIEW("振り返り", Icons.Default.Star);
}
