package com.kekod.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kekod.newsapp.R
import com.kekod.newsapp.databinding.FragmentPreviewBinding
import com.kekod.newsapp.viewModel.bodyList
import com.kekod.newsapp.viewModel.headList
import com.kekod.newsapp.viewModel.imageList

private const val ARG_PARAM1 = "count"

class PreviewFragment : Fragment() {

    private var param1: String? = null
    private lateinit var fragmentPreviewBinding: FragmentPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentPreviewBinding =  FragmentPreviewBinding.inflate(inflater,container,false)
        fragmentPreviewBinding.count = param1
        listeners()
        randomDay()

        fragmentPreviewBinding.fragmentPreview.background = imageList[param1?.toInt()!!]
        fragmentPreviewBinding.textViewHead.text = headList[param1?.toInt()!!]
        fragmentPreviewBinding.textViewBody.text = bodyList[param1?.toInt()!!]


        return fragmentPreviewBinding.root
    }
    private fun randomDay(){

        val rnd = (1..24).random()
        fragmentPreviewBinding.day = "$rnd hour ago"
    }
    private fun listeners(){
        fragmentPreviewBinding.fragmentPreview.setOnClickListener {

            param1?.let { it1 -> MainActivity.selectedFrame(it1) }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) : Fragment =
            PreviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
            }
        }
    }
}