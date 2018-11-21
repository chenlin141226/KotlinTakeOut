package com.hardy.jaffa.kotlintakeout.model.beans

import android.content.pm.ActivityInfo
import java.io.Serializable
import java.util.*

data class Seller(var id: Long, var pic: String, var name: String, var score: String, var sale: String,
                  var ensure: String, var invoice: String, var sendPrice: String, var deliveryFee: String,
                  var recentVisit: String, var distance: String, var time: String, var icon: String,
                  var activityList: ArrayList<ActivityInfo>) : Serializable{

//    var id: Long = 0
//    var pic: String? = null
//    var name: String? = null
//
//    var score: String? = null
//    var sale: String? = null
//    var ensure: String? = null
//
//    var invoice: String? = null
//    var sendPrice: String? = null
//    var deliveryFee: String? = null
//
//    var recentVisit: String? = null
//    var distance: String? = null
//    var time: String? = null
//
//    var icon: String? = null
//
//    var activityList: ArrayList<ActivityInfo>? = null

}
