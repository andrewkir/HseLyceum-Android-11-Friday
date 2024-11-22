package ru.andrewkir.testingapplication.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingapplication.presentation.contract.GoodsEvent
import ru.andrewkir.testingapplication.presentation.contract.GoodsState

@Composable
fun GoodsScreenContent(
  state: GoodsState,
  onEvent: (GoodsEvent) -> Unit,
) {
  Column {

    Row(modifier = Modifier.padding(16.dp)) {
      Column {
        TextField(value = state.textNameState,
          onValueChange = { changedValue -> onEvent(GoodsEvent.OnNameUpdated(changedValue)) },
          label = { Text("Enter name") }
        )

        TextField(value = state.textPriceState,
          onValueChange = { changedValue -> onEvent(GoodsEvent.OnPriceUpdated(changedValue)) },
          label = { Text("Enter price") }
        )
      }

      Spacer(Modifier.weight(1f))

      Button(onClick = {
        onEvent(GoodsEvent.OnButtonClicked)
      }) {
        Text("Add")
      }
    }
    LazyColumn {
      state.goods.forEach { item ->
        item {
          GoodsCard(
            item = item
          )
        }

        item {
          Spacer(modifier = Modifier.padding(vertical = 8.dp))
        }
      }
    }
  }
}