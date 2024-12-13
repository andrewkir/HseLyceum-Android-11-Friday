package ru.andrewkir.testingapplication.presentation.goods.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.andrewkir.testingapplication.data.api.GithubApi
import ru.andrewkir.testingapplication.model.GoodsModel
import ru.andrewkir.testingapplication.presentation.goods.component.AmountInStock.MEDIUM
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEffect
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEffect.OpenGoodsDetails
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnButtonClicked
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnCardClick
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnNameUpdated
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsEvent.OnPriceUpdated
import ru.andrewkir.testingapplication.presentation.goods.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())
  private val _effect = Channel<GoodsEffect>()
  val effect = _effect.receiveAsFlow()

  private fun setEffect(effect: GoodsEffect) {
    when (effect) {
      is OpenGoodsDetails -> {
        viewModelScope.launch {
          _effect.send(OpenGoodsDetails(effect.item))
        }
      }
    }
  }

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is OnNameUpdated -> {
        state.value = state.value.copy(textNameState = event.text)
      }

      OnButtonClicked -> {
        val api = getApi()
        viewModelScope.launch {
          try {
            val users = api.getUsers()
            state.value = state.value.copy(
              goods = users.map {user ->
                GoodsModel(
                  name = user.login,
                  price = 0,
                  rating = 5,
                  imageURL = user.avatarUrl,
                  amount = MEDIUM,
                )
              },
              textNameState = "",
              textPriceState = "",
            )
          } catch (e: Exception) {
            Log.e("Request error", e.message ?: "error")
          }
        }
      }

      is OnPriceUpdated -> {
        if (event.price.isNumeric()) {
          state.value = state.value.copy(textPriceState = event.price)
        }
      }

      is OnCardClick -> {
        setEffect(OpenGoodsDetails(event.item))
      }
    }
  }

  private fun getApi(): GithubApi {
    val okHttpClient = Builder()
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    okHttpClient.addInterceptor(logging)

    val retrofit = Retrofit.Builder()
      .baseUrl("https://api.github.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(okHttpClient.build())
      .build()

    return retrofit.create(GithubApi::class.java)
  }

  private fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
  }
}