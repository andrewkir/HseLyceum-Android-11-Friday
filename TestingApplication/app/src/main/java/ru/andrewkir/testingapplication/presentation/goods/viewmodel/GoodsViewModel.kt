package ru.andrewkir.testingapplication.presentation.goods.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEffect
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEffect.OpenGoodsDetails
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnButtonClicked
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnNameUpdated
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnPriceUpdated
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())
  private val _effect = Channel<GoodsEffect>()
  val effect = _effect.receiveAsFlow()

  private fun setEffect(effect: GoodsEffect) {
    when (effect) {
      OpenGoodsDetails -> {
        viewModelScope.launch {
          _effect.send(OpenGoodsDetails)
        }
      }
    }
  }

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is OnNameUpdated -> {
        state.value = state.value.copy(textNameState = event.text)
      }

      OnButtonClicked -> {
        setEffect(OpenGoodsDetails)
//        state.value = state.value.copy(
//          goods = listOf(
//            GoodsModel(
//              name = state.value.textNameState,
//              price = state.value.textPriceState.toInt(),
//              rating = 4,
//              image = R.drawable.lapki,
//              amount = MEDIUM,
//            )
//          )
//            + state.value.goods,
//          textNameState = "",
//          textPriceState = "",
//        )
      }

      is OnPriceUpdated -> {
        if (event.price.isNumeric()) {
          state.value = state.value.copy(textPriceState = event.price)
        }
      }
    }
  }

  private fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
  }
}