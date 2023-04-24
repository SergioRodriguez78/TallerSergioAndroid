package com.softwarejourneys.tallersergio.compose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softwarejourneys.tallersergio.ui.movies.MoviesViewModel
import com.softwarejourneys.tallersergio.ui.movies.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelCompose: ViewModel() {
    private val _userTextState = MutableStateFlow("")
    val userTextState = _userTextState.asStateFlow()


    private val _pwtTextState = MutableStateFlow("")
    val pwtTextState = _pwtTextState.asStateFlow()

    private val vm= MoviesViewModel()


    fun onTextChangeUser(newValue:String){
        _userTextState.value= newValue
    }
    fun onTextChangePwt(newValue:String){
        _pwtTextState.value= newValue
    }

       fun movies():List<Movie>{

          return movies
    }


}

val movies= listOf<Movie>(
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),
    Movie(1,"https://depor.com/resizer/1rXVVbd2pBfrAqtfHEruB7BOMZo=/1200x800/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/IJFGMKBMJ5DATPRGIIPPPCNNXI.jpg","adfda",232,false),

)