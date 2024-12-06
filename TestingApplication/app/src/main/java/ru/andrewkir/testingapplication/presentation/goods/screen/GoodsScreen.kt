package ru.andrewkir.testingapplication.presentation.goods.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest
import ru.andrewkir.testingapplication.presentation.destinations.GoodsDetailScreenContentDestination
import ru.andrewkir.testingapplication.presentation.goods.component.GoodsScreenContent
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEffect.OpenGoodsDetails
import ru.andrewkir.testingapplication.presentation.goods.viewmodel.GoodsViewModel

@RootNavGraph(start = true)
@Destination
@Composable
fun GoodsScreen(
  navigator: DestinationsNavigator
) {

  val viewModel = viewModel<GoodsViewModel>()

  val state by viewModel.state.collectAsState()

  GoodsScreenContent(
    state = state,
    onEvent = viewModel::handleEvent
  )

  LaunchedEffect(viewModel.effect) {
    viewModel.effect.collectLatest { effect ->
      when(effect){
        OpenGoodsDetails -> {
          navigator.navigate(GoodsDetailScreenContentDestination)
        }
      }
    }
  }
}