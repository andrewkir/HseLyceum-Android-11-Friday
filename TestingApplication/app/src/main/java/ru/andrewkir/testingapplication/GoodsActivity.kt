package ru.andrewkir.testingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingapplication.model.GoodsModel
import ru.andrewkir.testingapplication.presentation.component.AmountInStock.MEDIUM
import ru.andrewkir.testingapplication.presentation.component.GoodsCard
import ru.andrewkir.testingapplication.ui.theme.TestingApplicationTheme

class GoodsActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      TestingApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          LazyColumn(
            modifier = Modifier
              .padding(innerPadding)
          ) {
            val extras = intent.extras
            val value = extras?.getString("NAME")
            item {
              Text(text = value ?: "cant get name :(")
            }
            item {
              GoodsList()
            }
          }
        }
      }
    }
  }

  @Composable
  private fun GoodsList() {
    val goods = listOf(
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
      GoodsModel(
        name = "Лапка",
        price = 3000,
        rating = 4,
        image = R.drawable.lapki,
        amount = MEDIUM,
      ),
    )
    goods.forEach { item ->
      GoodsCard(
        item = item
      )

      Spacer(modifier = Modifier.padding(vertical = 8.dp))
    }
  }

  @Composable
  @Preview
  private fun GoodsListPreview() {
    GoodsList()
  }
}