package com.example.data.db

import androidx.room.TypeConverter
import com.example.data.entities.MediaEntity
import com.example.data.entities.MediaMetaDataEntity
import com.example.domain.models.Media
import com.example.domain.models.MediaMetaData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {

    @TypeConverter
    fun fromMediaListToString(data:ArrayList<MediaEntity>?) : String? =
        Gson().toJson(data)

    @TypeConverter
    fun fromStringToMediaList(data:String?) : ArrayList<MediaEntity>? {
        val type=object :TypeToken<ArrayList<MediaEntity>>(){}.type
        return Gson().fromJson(data,type)
    }

    @TypeConverter
    fun fromMetaDataToString(data:ArrayList<MediaMetaDataEntity>):String=
        Gson().toJson(data)

    @TypeConverter
    fun fromStringToMetaData(data:String) : ArrayList<MediaMetaDataEntity> {
        val type=object :TypeToken<ArrayList<MediaMetaDataEntity>>(){}.type
        return Gson().fromJson(data,type)
    }

}