package com.kekod.newsapp.view

import android.graphics.Color
import android.graphics.Color.alpha
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.kekod.newsapp.R
import com.kekod.newsapp.databinding.FragmentDetailBinding
import com.kekod.newsapp.viewModel.FragmentController.Companion.alphaSet
import com.kekod.newsapp.viewModel.headList
import com.kekod.newsapp.viewModel.imageList
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.NonCancellable.start

private const val ARG_PARAM1 = "param1"

class DetailFragment : Fragment() {

    private var param1: String? = null
    private lateinit var fragmentDetailBinding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater,container,false)
        fragmentDetailBinding.count = param1
        fragmentDetailBinding.imageViewNews.setImageDrawable(imageList[param1?.toInt()!!])
        fragmentDetailBinding.textViewHead.text = headList[param1?.toInt()!!]

        alphaSet(fragmentDetailBinding.viewDropCap,1500,750)
        alphaSet(fragmentDetailBinding.textViewLong,1500,1250)
        alphaSet(fragmentDetailBinding.textViewShort,1500,500)



        return fragmentDetailBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}