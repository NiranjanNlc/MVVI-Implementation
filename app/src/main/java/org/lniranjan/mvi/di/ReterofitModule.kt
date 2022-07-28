package org.lniranjan.mvi.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lniranjan.mvi.model.Blog
import org.lniranjan.mvi.reterofit.BlogNetworkEntity
import org.lniranjan.mvi.reterofit.BlogReterofit
import org.lniranjan.mvi.reterofit.NetworkMapeer
import org.lniranjan.mvi.utility.EntityMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReterofitModule {

    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<BlogNetworkEntity,Blog>
    {
        return NetworkMapeer()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson:  Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): BlogReterofit {
        return retrofit
            .build()
            .create(BlogReterofit::class.java)
    }

}