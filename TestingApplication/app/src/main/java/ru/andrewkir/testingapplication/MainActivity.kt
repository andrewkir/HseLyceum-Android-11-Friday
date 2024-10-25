package ru.andrewkir.testingapplication

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingapplication.ui.component.NewsArticle
import ru.andrewkir.testingapplication.ui.component.NewsCard
import ru.andrewkir.testingapplication.ui.component.ProfileScreen
import ru.andrewkir.testingapplication.ui.theme.TestingApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      TestingApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding)) {
            ProfileScreen(onButtonClick = {
              val intent = Intent(baseContext, SecondActivity::class.java)
              intent.putExtra("NAME", "Ivan")
              startActivity(intent)
            })
          }
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  TestingApplicationTheme {
    ProfileScreen{}
  }
}