package com.example.multisampleapp.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.multisampleapp.R
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private lateinit var galleryViewModel: GalleryViewModel

    /*override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //galleryViewModel =
                //ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        //val root = inflater.inflate(R.layout.fragment_gallery, container, false)
       *//* val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*//*
        return root
    }*/

    lateinit var intFlow: Flow<Int>

    lateinit var flowOne : Flow<String>
    lateinit var flowTwo : Flow<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFlow()
        setupFlows()
        setupClicks()
    }

    private fun setupFlows() {
        flowOne = flowOf("A", "B", "C")
        flowTwo = flowOf("D", "E", "F")
    }

    private fun setupClicks() {
        button.setOnClickListener {
            /*CoroutineScope(Dispatchers.Main).launch {
                intFlow.collect {
                    Log.d(TAG, "setupClicks: $it")
                }
            }*/

            CoroutineScope(Dispatchers.Main).launch {
                //flowOne.zip(flowTwo)
            }
        }
    }

    @ExperimentalCoroutinesApi
    private fun setupFlow() {
        /*intFlow = flow {
            Log.d(TAG, "setupFlow: start flow")
            (0..10).forEach {
                kotlinx.coroutines.delay(500)
                Log.d(TAG, "setupFlow: emitting $it")
                emit(it)
            }
        }
            .map { it * it }
            .flowOn(Dispatchers.Default)*/

        //intFlow = flowOf(1,2,3,4).onEach { delay(500) }.flowOn(Dispatchers.Default)
        //intFlow = (1..5).asFlow().onEach { delay(400) }.flowOn(Dispatchers.Default)

        intFlow = channelFlow {
            (0..10).forEach {
                send(it)
            }
        }.flowOn(Dispatchers.Default)
    }

    companion object {
        private val TAG = GalleryFragment::class.java.simpleName
    }

}
