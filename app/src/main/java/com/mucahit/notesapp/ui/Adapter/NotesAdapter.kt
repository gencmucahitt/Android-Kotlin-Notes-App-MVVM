package com.mucahit.notesapp.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mucahit.notesapp.Model.Notes
import com.mucahit.notesapp.R
import com.mucahit.notesapp.databinding.ItemNotesBinding

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>(){
    class notesViewHolder(val binding:ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data =notesList[position]
        holder.binding.apply {
            notesTitle.text=data.title
            notesSubTitle.text=data.subTitle
            notesDate.text=data.date

            when(data.priority){
                "1"->{
                    viewPriority.setBackgroundResource(R.drawable.green_dot)
                }
                "2"->{
                    viewPriority.setBackgroundResource(R.drawable.yellow_dot)
                }
                "3"->{
                    viewPriority.setBackgroundResource(R.drawable.red_dot)
                }
            }
        }


    }

    override fun getItemCount(): Int {
        val notesList = notesList.size
        return notesList
    }
}