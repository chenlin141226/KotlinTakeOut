package com.hardy.jaffa.kotlintakeout.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import com.hardy.jaffa.kotlintakeout.R
import com.hardy.jaffa.kotlintakeout.ui.fragment.HomeFragment
import com.hardy.jaffa.kotlintakeout.ui.fragment.MoreFragment
import com.hardy.jaffa.kotlintakeout.ui.fragment.OrderFragment
import com.hardy.jaffa.kotlintakeout.ui.fragment.UserFragment
import com.hardy.jaffa.kotlintakeout.utils.CheckNavigationBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   var fragments : List<Fragment> = listOf<Fragment>(HomeFragment(),OrderFragment(),UserFragment(),MoreFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //判断设备是否有虚拟按键，如果有加padingBottom-50dp
        if(CheckNavigationBar.checkDeviceHasNavigationBar(this)){
             ll_main_activity.setPadding(0,0,0,50.dp2px())
        }
        initBottomBar()
        changeIndex(0)
    }

    fun Int.dp2px(): Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,toFloat(),resources.displayMetrics).toInt()
    }

    //初始化Bottombar
    private fun initBottomBar() {
         for (i in 0 until main_bottom_bar.childCount){
             main_bottom_bar.getChildAt(i).setOnClickListener {
                 changeIndex(i)
             }
         }
    }

    //底部切换
    private fun changeIndex(index: Int) {
         for (i in 0 until main_bottom_bar.childCount){
             var child = main_bottom_bar.getChildAt(i)
             if(i == index){
                 //选中就禁用效果
                 setEnable(child,false)
             }else{
                 //没有选中的
                 setEnable(child,true)
             }
         }

      supportFragmentManager.beginTransaction().replace(R.id.main_content,fragments[index]).commit()
    }

    private fun setEnable(child: View, isEnable: Boolean) {
           child.isEnabled = isEnable
           if(child is ViewGroup){
               for (i in 0 until child.childCount){
                   setEnable(child.getChildAt(i),isEnable)
                  //child.getChildAt(i).isEnabled = isEnable
               }
           }
    }
}
