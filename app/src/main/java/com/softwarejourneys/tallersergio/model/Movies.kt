package com.softwarejourneys.tallersergio.model

data class Movies(var ImagenUrl: String, var name: String, var duration: Int, var favorito: Boolean){
    companion object{
var moviesDefault = listOf<Movies>(
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "Batman",
        120,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "spiderman",
        70,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "joker",
        40,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "señor de los anillos",
        240,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "adsfa",
        80,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "mackbook",
        456,
        true
    ),
    Movies(
        "https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png",
        "joker",
        40,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "Batman",
        120,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "spiderman",
        70,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "joker",
        40,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "señor de los anillos",
        240,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "adsfa",
        80,
        true
    ),
    Movies(
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "mackbook",
        456,
        true
    ),
    Movies(
        "https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png",
        "joker",
        40,
        true
    )
)}

    val movies= moviesDefault



}