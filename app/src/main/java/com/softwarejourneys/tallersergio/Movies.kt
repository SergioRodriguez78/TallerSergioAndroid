package com.softwarejourneys.tallersergio

class Movies {
    var imagenUrl: String = ""
    var name: String = ""
    var duracion: Int = 0
    var favorito: Boolean = false

    constructor()
    constructor(imagenUrl: String, name: String, duracion: Int, favorito: Boolean) {
        this.imagenUrl = imagenUrl
        this.name = name
        this.duracion = duracion
        this.favorito = favorito
    }


}