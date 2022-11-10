package com.example.unleeg7.Model

import java.io.Serializable
import java.sql.Timestamp

class Books: Serializable {
    lateinit var title: String
    lateinit var author: String
    lateinit var yearOfPublication: Timestamp
    lateinit var editorial: String
    lateinit var price: Number
}