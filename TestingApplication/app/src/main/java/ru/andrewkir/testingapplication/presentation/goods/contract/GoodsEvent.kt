package ru.andrewkir.testingapplication.presentation.goods.contract

sealed interface GoodsEvent {

  data class OnNameUpdated(val text: String): GoodsEvent
  data class OnPriceUpdated(val price: String): GoodsEvent

  data object OnButtonClicked: GoodsEvent
}