package com.example.domain.models

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("media-metadata")
    val media_metadata : ArrayList<MediaMetaData>
)