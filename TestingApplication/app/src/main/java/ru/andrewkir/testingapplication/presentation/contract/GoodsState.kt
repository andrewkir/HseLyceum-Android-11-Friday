package ru.andrewkir.testingapplication.presentation.contract

import ru.andrewkir.testingapplication.model.GoodsModel

data class GoodsState(
  val goods: List<GoodsModel> = emptyList(),
  val textFieldState: String = "",
)
