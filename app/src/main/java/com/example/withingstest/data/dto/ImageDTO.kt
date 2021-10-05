package com.example.withingstest.data.dto

import com.google.gson.annotations.SerializedName

data class ImageResponseDTO(@SerializedName("total") val total: Int,
                            @SerializedName("totalHits") val totalHits: Int,
                            @SerializedName("hits") val hits: List<ImageDTO>)


data class ImageDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("previewURL") val previewURL: String
)