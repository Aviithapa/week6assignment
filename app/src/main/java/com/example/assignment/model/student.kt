package com.example.assignment.model

import android.os.Parcel
import android.os.Parcelable
import com.example.assignment.`interface`.communicator

 data class student(
   var name:String,
   var age:Int,
   var address:String,
   var gender:String,
   var logo:String
)