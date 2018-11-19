package com.hardy.jaffa.kotlintakeout.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardy.jaffa.kotlintakeout.R
import com.hardy.jaffa.kotlintakeout.ui.adapter.HomeRvAdapter
import org.jetbrains.anko.find

class HomeFragment : Fragment() {

    private lateinit var homeRvAdapter : HomeRvAdapter//延迟加载注意和by lazy的区别

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.fragment_home, null)

        val rvHome = view.find<RecyclerView>(R.id.rv_home)
        //rvHome.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvHome.layoutManager = LinearLayoutManager(activity)
        homeRvAdapter = HomeRvAdapter(activity)
        rvHome.adapter = homeRvAdapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    private var datas : ArrayList<String> = ArrayList()
    private fun initData() {
        for (i in 0 until 100){
            datas.add("商家:$i")
        }

        homeRvAdapter.setData(datas)
    }
}