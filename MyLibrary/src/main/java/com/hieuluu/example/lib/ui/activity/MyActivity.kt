package com.hieuluu.example.lib.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.hieuluu.example.lib.R
import com.hieuluu.example.lib.core.BaseActivity
import com.hieuluu.example.lib.databinding.ActivityMyBinding
class MyActivity : BaseActivity() {
    private lateinit var binding: ActivityMyBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
    }

    override fun getBinding(inflater: LayoutInflater): ViewBinding {
        return binding
    }

    override fun getFragmentContainerId(): Int? {
        return 0
    }

    override fun setupViewModel() {
    }

    override fun initView() {
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initObserver() {
    }
}