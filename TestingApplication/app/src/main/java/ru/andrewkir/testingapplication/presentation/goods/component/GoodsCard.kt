package ru.andrewkir.testingapplication.presentation.goods.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.andrewkir.testingapplication.model.GoodsModel
import ru.andrewkir.testingapplication.presentation.goods.component.AmountInStock.MEDIUM
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GoodsCard(
  item: GoodsModel,
  onEvent: (GoodsEvent) -> Unit,
) {
  ElevatedCard(
    onClick = {
      onEvent(GoodsEvent.OnCardClick(item))
    }
  ) {
    GlideImage(
      modifier = Modifier
        .height(150.dp)
        .fillMaxWidth(),
      model = item.imageURL,
      contentDescription = "Фоновое изображение",
    )

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Text(
        text = item.name,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
      )

      Spacer(modifier = Modifier.weight(1f))

      for (i in 1..5) {
        Icon(
          imageVector = Icons.Default.Star,
          contentDescription = null,
          tint = if (i <= item.rating) {
            Color(0xFFD787B2)
          } else {
            Color(0xFFBDBDBD)
          }
        )
      }
    }

    Row {
      Text(
        modifier = Modifier.padding(
          start = 16.dp,
          bottom = 16.dp
        ),
        text = "${item.price}$",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
      )

      Spacer(modifier = Modifier.weight(1f))

      Text(
        text = "Наличие: ",
        fontSize = 20.sp
      )
      AmountComponent(
        modifier = Modifier.padding(end = 16.dp),
        amount = item.amount
      )
    }
  }
}

@Preview
@Composable
private fun GoodsCardPreview() {
  GoodsCard(
    item = GoodsModel(
      name = "Лапка",
      price = 3000,
      rating = 4,
      imageURL = "",
      amount = MEDIUM,
    ),
    onEvent = {}
  )
}