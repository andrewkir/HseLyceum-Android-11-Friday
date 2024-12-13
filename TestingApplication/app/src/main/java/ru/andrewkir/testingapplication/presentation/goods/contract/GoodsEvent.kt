package ru.andrewkir.testingapplication.presentation.goods.contract

import ru.andrewkir.testingapplication.model.GoodsModel

sealed interface GoodsEvent {

  data class OnNameUpdated(val text: String): GoodsEvent
  data class OnPriceUpdated(val price: String): GoodsEvent
  data class OnCardClick(val item: GoodsModel): GoodsEvent

  data object OnButtonClicked: GoodsEvent
}