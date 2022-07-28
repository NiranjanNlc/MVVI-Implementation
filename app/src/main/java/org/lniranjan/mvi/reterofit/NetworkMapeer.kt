package org.lniranjan.mvi.reterofit

import org.lniranjan.mvi.model.Blog
import org.lniranjan.mvi.utility.EntityMapper
import javax.inject.Inject

class NetworkMapeer @Inject constructor() : EntityMapper<BlogNetworkEntity,Blog>{
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainModel.id ,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogNetworkEntity>): List<Blog>{
        return entities.map { mapFromEntity(it) }
    }
}