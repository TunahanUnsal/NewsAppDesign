package com.kekod.newsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kekod.newsapp.R
import com.kekod.newsapp.databinding.ActivityMainBinding
import com.kekod.newsapp.viewModel.FragmentController
import com.kekod.newsapp.viewModel.FragmentController.Companion.createFragmentDetail
import com.kekod.newsapp.viewModel.FragmentController.Companion.createFragmentPreview
import com.kekod.newsapp.viewModel.FragmentController.Companion.hideNavigationBar
import com.kekod.newsapp.viewModel.FragmentController.Companion.imageRandom
import com.kekod.newsapp.viewModel.detailFragmentList
import com.kekod.newsapp.viewModel.frameList
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        hideNavigationBar(window)  //for bottom navigation bar
        fragmentSupportManager = supportFragmentManager
        frameBinding()
        clock()
        createFragmentPreview()
        createFragmentDetail()
        imageRandom(applicationContext)
        fragmentWizard()
        listeners()


        var animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_left)
        binding.upperFrame.startAnimation(animationSlideDown)

        animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_right)
        binding.upperFrame.startAnimation(animationSlideDown)

    }

    override fun onBackPressed() {
        fragmentWizard()
    }

    private fun fragmentWizard() {
        for (fragment in fragmentSupportManager.fragments) {
            fragmentSupportManager.beginTransaction().remove(fragment).commit()
        }
        for (i in 0 until frameList.size) {
            fragment = PreviewFragment.newInstance(i.toString())
            fragmentSupportManager.beginTransaction().add(frameList[i].id, fragment).commit()
        }
    }

    private fun frameBinding() {
        frameList.add(binding.frame1)
        frameList.add(binding.frame2)
        frameList.add(binding.frame3)
        frameList.add(binding.frame4)
        frameList.add(binding.frame5)
        frameList.add(binding.frame6)
        frameList.add(binding.frame7)
        frameList.add(binding.frame8)
    }

    private fun getDate(): String {
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance()
        return formatter.format(date)
    }

    private fun listeners() {

        binding.exit.setOnClickListener {
            fragmentWizard()
            binding.exit.visibility = View.GONE
            binding.dateText.visibility = View.VISIBLE
        }

    }

    private fun clock() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.date = getDate()
        }, 1000)
    }

    companion object {

        lateinit var binding: ActivityMainBinding
        private lateinit var fragmentSupportManager: FragmentManager

        fun selectedFrame(count: String) {
            Log.d("MainActivity", "selectedFrame: $count")
            for (fragment in fragmentSupportManager.fragments) {
                fragmentSupportManager.beginTransaction().remove(fragment).commit()
            }
            fragmentSupportManager.beginTransaction()
                .replace(R.id.frame1, detailFragmentList[count.toInt()]).commit()
            FragmentController.alphaSet(binding.frame1, 1000, 0)
            binding.exit.visibility = View.VISIBLE
            binding.dateText.visibility = View.GONE
            binding.scrollView.scrollTo(0,0)
        }
    }
}