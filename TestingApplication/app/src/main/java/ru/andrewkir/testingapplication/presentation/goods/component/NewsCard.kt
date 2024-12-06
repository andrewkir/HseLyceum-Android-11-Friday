package ru.andrewkir.testingapplication.presentation.goods.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.andrewkir.testingapplication.R

@Composable
fun NewsCard(
  article: NewsArticle,
) {
  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    ElevatedCard {
      Image(
        modifier = Modifier
          .height(200.dp)
          .fillMaxWidth(),
        painter = painterResource(R.drawable.image),
        contentDescription = null,
        contentScale = ContentScale.Crop
      )
      Text(
        modifier = Modifier
          .padding(horizontal = 16.dp, vertical = 8.dp),
        text = article.title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
      )
      Text(
        modifier = Modifier
          .padding(horizontal = 16.dp)
          .padding(bottom = 12.dp),
        text = article.subtitle,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

data class NewsArticle(
  val title: String,
  val subtitle: String,
)

@Preview
@Composable
private fun NewsCardPreview() {
  NewsCard(
    article = NewsArticle(
      title = "Title",
      subtitle = "Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle Subtitle ",
    )
  )
}