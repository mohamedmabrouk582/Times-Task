package com.example.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaMetaDataEntity (
    val url:String
        ): Parcelable