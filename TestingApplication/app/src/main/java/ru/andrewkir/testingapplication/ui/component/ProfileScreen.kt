package ru.andrewkir.testingapplication.ui.component

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.andrewkir.testingapplication.SecondActivity

@Composable
fun ProfileScreen(
  onButtonClick: () -> Unit,
) {
  Column(
    modifier = Modifier
      .padding(top = 16.dp)
      .padding(horizontal = 16.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Image(
        modifier = Modifier
          .size(52.dp)
          .clip(CircleShape)
          .background(Color.Cyan),
        imageVector = Icons.Filled.Person,
        contentDescription = null,
      )

      Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Ivan",
        fontSize = 24.sp
      )

      Button(
        modifier = Modifier.padding(start = 16.dp),
        onClick = {
          onButtonClick()
        }
      ) {
        Text(text = "Go")
      }
    }

    val news = listOf(
      NewsArticle("news1", "test"),
      NewsArticle("news2", "test"),
      NewsArticle("news3", "test"),
      NewsArticle("news4", "test"),
      NewsArticle("news5", "test"),
    )

    Text(
      modifier = Modifier.padding(top = 16.dp),
      text = "Избранные новости:"
    )

    LazyColumn(
      modifier = Modifier
        .padding(top = 16.dp)
    ) {
      news.forEach { item ->
        item {
          NewsCard(
            article = NewsArticle(
              title = item.title,
              subtitle = item.subtitle
            )
          )
        }

        item {
          Spacer(modifier = Modifier.padding(vertical = 8.dp))
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
  ProfileScreen {}
}