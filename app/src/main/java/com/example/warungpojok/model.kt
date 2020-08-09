package com.example.warungpojok

data class RequestInputMenu(
    val name : String,
    val description : String,
    val price : String,
    val category : String,
    val stock  : String,
    val image : String
)

data class ResponseInputMenu(
    val success : Boolean,
    val message : String
)