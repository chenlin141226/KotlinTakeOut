package com.hardy.jaffa.kotlintakeout.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardy.jaffa.kotlintakeout.R
import com.hardy.jaffa.kotlintakeout.presenter.HomeFragmentPresenter
import com.hardy.jaffa.kotlintakeout.ui.adapter.HomeRvAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.find

class HomeFragment : Fragment() {

    private lateinit var homeRvAdapter: HomeRvAdapter//延迟加载注意和by lazy的区别
    private lateinit var rvHome: RecyclerView
    private lateinit var presenter : HomeFragmentPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.fragment_home, null)
        presenter = HomeFragmentPresenter(this)

        rvHome = view.find<RecyclerView>(R.id.rv_home)
        //rvHome.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvHome.layoutManager = LinearLayoutManager(activity)
        homeRvAdapter = HomeRvAdapter(activity)
        rvHome.adapter = homeRvAdapter
        distanse = 120.dp2px()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    fun Int.dp2px(): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                toFloat(), resources.displayMetrics).toInt()

    }

    private var sum = 0
    var distanse = 0
    var alpha = 55
    private var datas: ArrayList<String> = ArrayList()
    private fun initData() {
        for (i in 0 until 100) {
            datas.add("商家:$i")
        }

        homeRvAdapter.setData(datas)

        //RecycleView的滑动监听
        rvHome.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //dy 是每一瞬间移动的距离类似于加速度
                //Log.e("Home", "$dy")
                sum += dy
                Log.e("Home", "$sum")
                if (sum > distanse) {
                    alpha = 255
                } else {
                    alpha = sum*200/ distanse
                }
                ll_title_container.setBackgroundColor(Color.argb(alpha, 0X31, 0x90, 0xe8))
            }
        })
    }



    fun onSuccess() {
    }

    fun onFail() {
    }
}