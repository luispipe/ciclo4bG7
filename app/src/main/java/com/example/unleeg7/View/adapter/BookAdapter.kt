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

class BookAdapter(private val context: Context):RecyclerView.Adapter<BookAdapter.ViewHolder>(), Adapter {
    var bookList= mutableListOf<books>()

    fun setListData(data:MutableList<books>){
        bookList=data
    }

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val view= LayoutInflater.from(ViewGroup.context).inflate(R.layout.card_view_book
        ,ViewGroup,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val book= bookList[i]
        viewHolder.binWew(book)
    }

    override fun getItemCount(): Int {
       return bookList.size
    }


   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun binWew(books: books){
            val img= itemView.findViewById<ImageView>(R.id.imgBook)
            Picasso.get().load(books.url).into(img)
            itemView.findViewById<TextView>(R.id.titleBook).text=books.title
            itemView.findViewById<TextView>(R.id.authorBook).text=books.author
            itemView.findViewById<TextView>(R.id.priceBook).text= books.price

        }
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}