package com.example.notesappwithroom.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappwithroom.R
import com.example.notesappwithroom.db.Note

interface ClickDeleteInterface {
    fun onClickDelete(note: Note)
}

interface ClickNoteInterface {
    fun onClickNote(note: Note)
}

class NoteAdapter(
    val context: Context,
    val clickDeleteInterface: ClickDeleteInterface,
    val clickNoteInterface: ClickNoteInterface
)
    : RecyclerView.Adapter<RecyclerView.ViewHolder> ()
{

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return allNotes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            val tvTimeStamp = findViewById<TextView>(R.id.tvTimeStamp)
            val ivDelete = findViewById<ImageView>(R.id.ivDelete)

            tvTitle.text = allNotes[position].title
            tvTimeStamp.text = "Last Updated: " + allNotes[position].timeStamp

            ivDelete.setOnClickListener {
                clickDeleteInterface.onClickDelete(allNotes[position])
            }
        }
    }

    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}