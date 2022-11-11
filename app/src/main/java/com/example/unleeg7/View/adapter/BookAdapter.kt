package com.example.unleeg7.View.adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.unleeg7.Model.books
import com.example.unleeg7.R
import com.squareup.picasso.Picasso

class BookAdapter(val context: Context):RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var bookList= mutableListOf<books>()

    fun setListData(data:MutableList<books>){
        bookList=data
    }

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(ViewGroup.context).inflate(R.layout.card_view_book
        ,ViewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val book= bookList[i]
        viewHolder.binWew(book)
    }

    override fun getItemCount(): Int {
       return bookList.size
    }


   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun binWew(book: books){

            Picasso.get().load(book.url).into(itemView.findViewById<ImageView>(R.id.imgBook))
            itemView.findViewById<TextView>(R.id.titleBook).text=book.title
            itemView.findViewById<TextView>(R.id.authorBook).text=book.author
            itemView.findViewById<TextView>(R.id.priceBook).text= book.price.toString()

        }
    }


}