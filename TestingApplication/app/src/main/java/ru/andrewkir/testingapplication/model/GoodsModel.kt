package ru.andrewkir.testingapplication.model

import androidx.annotation.DrawableRes
import ru.andrewkir.testingapplication.presentation.goods.component.AmountInStock

data class GoodsModel(
  val name: String,
  val price: Int,
  val amount: AmountInStock,
  @DrawableRes
  val image: Int,
  val rating: Int,
)