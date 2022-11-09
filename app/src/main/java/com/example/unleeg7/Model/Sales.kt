package com.example.unleeg7.Model

import java.io.Serializable
import java.sql.Timestamp

class Sales: Serializable {
   lateinit var book_title:String
   lateinit var user_email: String
   lateinit var total_value:Number
   lateinit var date: Timestamp
}