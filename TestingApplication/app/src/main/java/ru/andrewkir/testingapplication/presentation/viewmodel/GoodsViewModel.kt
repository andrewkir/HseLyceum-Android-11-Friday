package ru.andrewkir.testingapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.andrewkir.testingapplication.R
import ru.andrewkir.testingapplication.model.GoodsModel
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.MEDIUM
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent.OnButtonClicked
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent.OnTextUpdated
import ru.andrewkir.testingapplication.presentation.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  init {
    val goods = listOf(
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      )
    )

    state.value = state.value.copy(goods = goods)
  }

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is OnTextUpdated -> {
        state.value = state.value.copy(textFieldState = event.text)
      }

      OnButtonClicked -> {
        state.value = state.value.copy(
          goods = listOf(
            GoodsModel(
              name = state.value.textFieldState,
              price = 3000,
              rating = 4,
              image = R.drawable.lapki,
              amount = MEDIUM,
            )
          ) + state.value.goods,
          textFieldState = "",
        )
      }
    }
  }
}