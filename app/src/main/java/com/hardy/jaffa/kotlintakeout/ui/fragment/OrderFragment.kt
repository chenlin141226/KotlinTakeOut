package com.hardy.jaffa.kotlintakeout.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardy.jaffa.kotlintakeout.R

class OrderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = View.inflate(activity, R.layout.fragment_order, null)
        return view
    }
}