package com.example.withingstest.data.api

import com.example.withingstest.data.dto.ImageResponseDTO
import com.example.withingstest.data.model.Photo


class PhotosResponseMapper {

    fun map(albumsResponse: ImageResponseDTO): List<Photo> {
        val photoListDto = albumsResponse.hits

        return photoListDto.map { photoDto ->

            Photo(photoDto.id, photoDto.previewURL)
        }
    }
}