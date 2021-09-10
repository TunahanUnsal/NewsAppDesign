package com.kekod.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kekod.newsapp.R
import com.kekod.newsapp.databinding.FragmentDetailBinding

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