package ru.andrewkir.testingapplication.model

import com.google.gson.annotations.SerializedName

data class UserModel(
  @SerializedName("login")
  val login: String,

  @SerializedName("id")
  val id: Long,

  @SerializedName("avatar_url")
  val avatarUrl: String,
)
