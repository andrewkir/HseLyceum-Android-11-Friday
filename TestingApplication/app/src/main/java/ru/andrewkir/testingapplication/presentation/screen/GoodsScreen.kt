package ru.andrewkir.testingapplication.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.andrewkir.testingapplication.presentation.component.GoodsScreenContent
import ru.andrewkir.testingapplication.presentation.viewmodel.GoodsViewModel

@Composable
fun GoodsScreen() {

  val viewModel = viewModel<GoodsViewModel>()

  val state by viewModel.state.collectAsState()

  GoodsScreenContent(
    state = state,
    onEvent = viewModel::handleEvent
  )
}