package ru.andrewkir.testingapplication.presentation.contract

sealed interface GoodsEvent {

  data class OnTextUpdated(val text: String): GoodsEvent

  data object OnButtonClicked: GoodsEvent
}