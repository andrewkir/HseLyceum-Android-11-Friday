package ru.andrewkir.testingapplication.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import ru.andrewkir.testingapplication.model.GoodsModel

@Destination
@Composable
fun GoodsDetailScreenContent(
    item: GoodsModel,
) {

  Text("HELLO ${item.name}")
}