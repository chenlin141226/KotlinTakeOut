package com.hardy.jaffa.kotlintakeout.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.hardy.jaffa.kotlintakeout.R
import org.jetbrains.anko.find

class HomeRvAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {    //类似与java中申明public static final
        const val TYPE_TITLE = 0
        const val TYPE_SELLER = 1
    }

    /**
     * 不同position对应不同类型
     */
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_TITLE
        } else {
            TYPE_SELLER
        }
    }


    var mDatas: ArrayList<String> = ArrayList()
    fun setData(data: ArrayList<String>) {
        this.mDatas = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when (viewType) {
            TYPE_TITLE -> (holder as TitleHolder).bindData("我是大哥----------------------------------------")
            TYPE_SELLER -> (holder as SellerHolder).bindData(mDatas[position - 1])
        }

    }

    override fun getItemCount(): Int {
        return if (mDatas.size > 0) {
            mDatas.size + 1
        } else {
            0
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TITLE -> TitleHolder(View.inflate(context, R.layout.item_title, null))
            TYPE_SELLER -> SellerHolder(View.inflate(context, R.layout.item_seller, null))
            else -> TitleHolder(View.inflate(context, R.layout.item_home_common, null))
        }
    }

    var url_maps: HashMap<String, String> = HashMap()

    inner class TitleHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val slideLayout: SliderLayout = item.find(R.id.slider) as SliderLayout

        fun bindData(data: String) {
            if (url_maps.size == 0) {
                url_maps["Hannibal"] = "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg"
                url_maps["Big Bang Theory"] = "http://tvfiles.alphacoders.com/100/hdclearart-10.png"
                url_maps["House of Cards"] = "http://cdn3.nflximg.net/images/3093/2043093.jpg"
                url_maps["Game of Thrones"] = "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg"

                for ((key, value) in url_maps) {
                    val textSlideView = TextSliderView(context)
                    textSlideView.description(key).image(value)
                    slideLayout.addSlider(textSlideView)
                }
            }
        }
    }

    inner class SellerHolder(item: View) : RecyclerView.ViewHolder(item) {


        fun bindData(data: String) {

        }
    }
}