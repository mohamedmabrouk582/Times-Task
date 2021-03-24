package com.example.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaEntity(
    @SerializedName("media-metadata")
    val media_metadata : ArrayList<MediaMetaDataEntity>
) : Parcelable