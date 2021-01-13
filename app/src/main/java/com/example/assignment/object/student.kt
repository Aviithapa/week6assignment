package com.example.assignment.`object`

import com.example.assignment.model.student

object student {
    var lststudent= arrayListOf<student>()
    fun loadPost() {
        lststudent.add(student("Abhishek",22,"Tripura","male","https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Zayn_Wiki_%28cropped%29.jpg/220px-Zayn_Wiki_%28cropped%29.jpg"))
        lststudent.add(student("bhupendra",22,"Tripura","male","https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Zayn_Wiki_%28cropped%29.jpg/220px-Zayn_Wiki_%28cropped%29.jpg"))
    }
}