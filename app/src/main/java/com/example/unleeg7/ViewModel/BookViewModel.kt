package com.example.unleeg7.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unleeg7.Domain.repository
import com.example.unleeg7.Model.books

class BookViewModel:ViewModel() {
    val repository= repository()

    fun fetchBookData(): LiveData<MutableList<books>>{
        val mutableLiveData= MutableLiveData<MutableList<books>>()
        repository.getBooksData().observeForever{
            mutableLiveData.value=it
        }
        return mutableLiveData
    }
}