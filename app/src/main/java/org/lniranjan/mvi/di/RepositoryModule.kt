package org.lniranjan.mvi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.lniranjan.mvi.repository.MainRepository
import org.lniranjan.mvi.reterofit.BlogReterofit
import org.lniranjan.mvi.reterofit.NetworkMapeer
import org.lniranjan.mvi.room.BlogCacheMapper
import org.lniranjan.mvi.room.BlogDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogReterofit,
        cacheMapper: BlogCacheMapper,
        networkMapper: NetworkMapeer
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}