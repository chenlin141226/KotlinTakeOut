package com.hardy.jaffa.kotlintakeout.presenter

import com.hardy.jaffa.kotlintakeout.ui.fragment.HomeFragment
import retrofit2.Retrofit

class HomeFragmentPresenter(val homeFragment: HomeFragment) {

    init {
        var retrofit = Retrofit.Builder().baseUrl("").build()
    }

    //获取首页方法
    fun getHomeInfo(){
        //成功数据的回调
        homeFragment.onSuccess()

        //失败数据的回调
        homeFragment.onFail()
    }

}