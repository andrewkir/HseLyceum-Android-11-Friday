package ru.andrewkir.testingapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.andrewkir.testingapplication.R
import ru.andrewkir.testingapplication.model.GoodsModel
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.MEDIUM
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent.OnButtonClicked
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent.OnNameUpdated
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent.OnPriceUpdated
import ru.andrewkir.testingapplication.presentation.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is OnNameUpdated -> {
        state.value = state.value.copy(textNameState = event.text)
      }

      OnButtonClicked -> {
        state.value = state.value.copy(
          goods = listOf(
            GoodsModel(
              name = state.value.textNameState,
              price = state.value.textPriceState.toInt(),
              rating = 4,
              image = R.drawable.lapki,
              amount = MEDIUM,
            )
          )
            + state.value.goods,
          textNameState = "",
          textPriceState = "",
        )
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