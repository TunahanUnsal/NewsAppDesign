package com.kekod.newsapp.viewModel

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.Window
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.kekod.newsapp.R
import com.kekod.newsapp.view.DetailFragment
import com.kekod.newsapp.view.PreviewFragment

val previewFragmentList = mutableListOf<Fragment>()
val detailFragmentList = mutableListOf<Fragment>()
var frameList: MutableList<FrameLayout> = mutableListOf()
var imageList: MutableList<Drawable?> = mutableListOf()
var headList: MutableList<String?> = mutableListOf()
var bodyList: MutableList<String?> = mutableListOf()

class FragmentController {

    companion object{

        @JvmStatic
        fun alphaSet(view : View,time : Long,delay : Long){

            view.alpha = 0.0f
            view.animate().apply {
                interpolator = LinearInterpolator()
                duration = time
                alpha(1f)
                startDelay = delay
                start()
            }

        }

        @JvmStatic
        fun createFragmentPreview(){

            for (i in 0..7) {

                val fragment = PreviewFragment.newInstance(i.toString())
                previewFragmentList.add(fragment)

            }
        }

        @JvmStatic
        fun createFragmentDetail(){

            for (i in 0 until previewFragmentList.size) {

                val fragment = DetailFragment.newInstance(i.toString())
                detailFragmentList.add(fragment)

            }
        }
        @JvmStatic
        fun hideNavigationBar(window : Window) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
        @JvmStatic
        fun imageRandom(mContex : Context) {

            var drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme1)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme2)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme3)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme4)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme5)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme6)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme7)
            imageList.add(drawable)
            drawable = AppCompatResources.getDrawable(mContex,R.drawable.deneme8)
            imageList.add(drawable)

            var head = mContex.getString(R.string.news_head_1)
            headList.add(head)
            head = mContex.getString(R.string.news_head_2)
            headList.add(head)
            head = mContex.getString(R.string.news_head_3)
            headList.add(head)
            head = mContex.getString(R.string.news_head_4)
            headList.add(head)
            head =mContex.getString(R.string.news_head_6)
            headList.add(head)
            head = mContex.getString(R.string.news_head_7)
            headList.add(head)
            head = mContex.getString(R.string.news_head_8)
            headList.add(head)
            head = mContex.getString(R.string.news_head_9)
            headList.add(head)


            var body = mContex.getString(R.string.news_body_1)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_2)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_3)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_4)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_6)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_7)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_8)
            bodyList.add(body)
            body = mContex.getString(R.string.news_body_9)
            bodyList.add(body)

        }
    }

}