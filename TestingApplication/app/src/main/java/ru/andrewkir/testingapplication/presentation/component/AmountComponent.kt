package ru.andrewkir.testingapplication.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.EMPTY
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.FULL
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.LOW
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.MEDIUM

@Composable
fun AmountComponent(
  modifier: Modifier = Modifier,
  amount: AmountInStock,
) {
  val color = when(amount){
    FULL -> Color(0xFF35FF00) //if(amount is AmountInStock.Full)
    MEDIUM -> Color(0xFFFFF200)
    LOW -> Color(0xFFFF0900)
    EMPTY -> Color(0xFFCCCCCC)
  }

  Row(modifier = modifier) {
    for (i in 1..5) {
      val columnColor = if (i <= amount.amount) color else Color(0xFFCCCCCC)
      Box(
        modifier = Modifier
          .background(columnColor)
          .width(10.dp)
          .height(20.dp)
      )

      if (i != 5) {
        Spacer(modifier = Modifier.width(1.dp))
      }
    }
  }
}

enum class AmountInStock(
  val amount: Int,
) {
  FULL(
    5
  ),
  MEDIUM(
    3
  ),
  LOW(
    1
  ),
  EMPTY(
    0
  )
}

@Composable
@Preview
private fun AmountComponentPreviewFull() {
  AmountComponent(
    amount = FULL
  )
}

@Composable
@Preview
private fun AmountComponentPreviewLow() {
  AmountComponent(
    amount = LOW
  )
}