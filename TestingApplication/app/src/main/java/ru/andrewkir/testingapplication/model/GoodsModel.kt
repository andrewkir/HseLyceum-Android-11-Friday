package ru.andrewkir.testingapplication.model

import kotlinx.serialization.Serializable
import ru.andrewkir.testingapplication.presentation.goods.component.AmountInStock

@Serializable
data class GoodsModel(
  val name: String,
  val price: Int,
  val amount: AmountInStock,
  val imageURL: String,
  val rating: Int,
)