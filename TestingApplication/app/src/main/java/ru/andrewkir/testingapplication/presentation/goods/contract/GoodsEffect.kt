package ru.andrewkir.testingapplication.presentation.goods.contract

sealed interface GoodsEffect {

  data object OpenGoodsDetails: GoodsEffect
}