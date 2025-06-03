package org.khaki.projects.screen.home

import org.khaki.projects.screen.home.components.TaskCardUiState

sealed interface TodayTaskListUiState {

    data object Empty : TodayTaskListUiState

    data object Loading : TodayTaskListUiState

    data class Success(
        val taskList: List<TaskCardUiState>
    ) : TodayTaskListUiState

    data class Error(
        val message: String
    ) : TodayTaskListUiState

}