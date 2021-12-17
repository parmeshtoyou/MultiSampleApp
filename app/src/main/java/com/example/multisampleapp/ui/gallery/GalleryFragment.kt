package com.example.multisampleapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.multisampleapp.R
import com.example.multisampleapp.factory.GalleryVMFactory
import kotlinx.coroutines.flow.collect

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        galleryViewModel = ViewModelProvider(this, GalleryVMFactory(100))[GalleryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        val button: Button = root.findViewById(R.id.button)

        lifecycleScope.launchWhenResumed {
            galleryViewModel.text.collect {
                textView.text = it
            }
        }

        button.setOnClickListener {
            galleryViewModel.setSomeValue("Parmesh Mahore")
        }
        return root
    }
}
