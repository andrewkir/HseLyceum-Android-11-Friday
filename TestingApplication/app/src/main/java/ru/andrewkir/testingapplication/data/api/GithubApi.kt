package ru.andrewkir.testingapplication.data.api

import retrofit2.http.GET
import ru.andrewkir.testingapplication.model.UserModel

interface GithubApi {

  @GET("/users?since=<string>&per_page=30")
  suspend fun getUsers(): List<UserModel>
}