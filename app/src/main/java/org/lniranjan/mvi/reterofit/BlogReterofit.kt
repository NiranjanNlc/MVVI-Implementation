package org.lniranjan.mvi.reterofit

import retrofit2.http.GET

interface BlogReterofit {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}