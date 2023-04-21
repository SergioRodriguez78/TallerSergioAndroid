package com.softwarejourneys.tallersergio.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Date


data class MovieResponse(
    @SerializedName("page") var page:Int,
    @SerializedName("results") var results: List<MovieDB>,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("vote_count") var voteCount: Int
    ){

}


data class MovieDB(

    @SerializedName("adult") var adult: Boolean,
    @SerializedName("backdrop_path") var backdrop_path:String,
    @SerializedName("genre_ids") var genre_ids:List<Int>,
    @SerializedName("id")val id: Int,
    @SerializedName("original_language") var original_language:String,
    @SerializedName("original_title") var original_title:String,
    @SerializedName("overview") var overview:String,
    @SerializedName("popularity") var popularity:Double,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("release_date") var release_date: Date,
    @SerializedName("title") var title: String,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var vote_average: Double,
    @SerializedName("vote_count") var vote_count:Int

)
@Entity
data class Movie(
    @PrimaryKey val id: Int, //id
    var ImageUrl: String, //posterpath
    var name: String,//title
    var duration: Int,//vote ocunt
    var favorite: Boolean //adult
)