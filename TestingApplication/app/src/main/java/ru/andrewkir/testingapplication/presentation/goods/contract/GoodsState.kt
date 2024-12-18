package ru.andrewkir.testingapplication.presentation.goods.contract

import ru.andrewkir.testingapplication.model.GoodsModel

data class GoodsState(
  val goods: List<GoodsModel> = emptyList(),
  val textNameState: String = "",
  val textPriceState: String = "",
)
