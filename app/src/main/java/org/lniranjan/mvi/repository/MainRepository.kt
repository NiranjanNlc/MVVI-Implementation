package org.lniranjan.mvi.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lniranjan.mvi.model.Blog
import org.lniranjan.mvi.reterofit.BlogReterofit
import org.lniranjan.mvi.reterofit.NetworkMapeer
import org.lniranjan.mvi.room.BlogCacheMapper
import org.lniranjan.mvi.room.BlogDao
import org.lniranjan.mvi.utility.DataState

class MainRepository constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogReterofit,
    private val cacheMapper: BlogCacheMapper,
    private val networkMapper: NetworkMapeer
) {
    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogRetrofit.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs) {
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}