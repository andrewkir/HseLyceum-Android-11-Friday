package ru.andrewkir.testingapplication.presentation.goods.contract

import ru.andrewkir.testingapplication.model.GoodsModel

sealed interface GoodsEffect {

  data class OpenGoodsDetails(val item: GoodsModel): GoodsEffect
}