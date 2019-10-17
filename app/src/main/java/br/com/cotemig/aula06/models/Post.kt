package br.com.cotemig.aula06.models

data class Post(

    var id: String,
    var user: String,
    var avatar: String,
    var local: String,
    var date: String,
    var image: String,
    var description: String,
    var likes: List<String>,
    var gallery: List<Image>

)