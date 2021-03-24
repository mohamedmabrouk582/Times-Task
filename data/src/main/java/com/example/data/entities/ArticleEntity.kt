package com.example.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.test.core.os.Parcelables
import com.example.domain.models.Media
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class ArticleEntity(
    @PrimaryKey
    var id:Long?=null,
    var title:String?=null,
    var byline:String?=null,
    var abstract:String?=null,
    var source:String?=null,
    var published_date:String?=null,
    var updated:String?=null,
    var section:String?=null,
    var subsection:String?=null,
    var nytdsection:String?=null,
    var adx_keywords:String?=null,
    var media:ArrayList<MediaEntity>?=null
) : Parcelable{
    var image : String=""
        get() = try {
            media?.get(0)?.media_metadata?.get(2)?.url ?: ""
        }catch (e:Exception){ "" }
}