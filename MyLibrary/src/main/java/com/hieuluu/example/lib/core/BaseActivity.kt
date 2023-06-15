package com.hieuluu.example.lib.core

import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 * Created by Hieu Luu (neo) on 15/06/2023
 */
abstract class BaseActivity : AppCompatActivity() {
    var configurationChangedListener: ((Configuration) -> Unit)? = null

    open fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
            super.onBackPressed()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val displayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displayMetrics)
        Log.d(
            "BaseActivity",
            "Configuration Changed: \n Window size ${displayMetrics.widthPixels}x${displayMetrics.heightPixels}"
        )
        configurationChangedListener?.invoke(newConfig)
    }

    abstract fun getBinding(inflater: LayoutInflater): ViewBinding
    abstract fun getFragmentContainerId(): Int?
    abstract fun setupViewModel()
    abstract fun initView()
    abstract fun initData(savedInstanceState: Bundle?)
    abstract fun initObserver()
}