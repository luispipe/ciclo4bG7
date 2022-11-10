package com.example.unleeg7.Model

import java.io.Serializable
import java.sql.Timestamp


class user: Serializable {
    lateinit var name: String
    lateinit var email: String
    lateinit var bithDate: Timestamp
}