package com.example.multisampleapp.ui.notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.multisampleapp.R
import com.example.multisampleapp.viewmodel.NotesViewModel

class NotesFragment : Fragment(R.layout.fragment_notes) {

    private var notesViewModel: NotesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerNotesList()
        notesViewModel?.getNotesList()
    }

    private fun observerNotesList() {
        notesViewModel?.notesLiveData?.observe(viewLifecycleOwner, Observer {
            println(it)
        })
    }
}