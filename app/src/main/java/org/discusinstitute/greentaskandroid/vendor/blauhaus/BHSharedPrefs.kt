package org.discusinstitute.greentaskandroid.vendor.blauhaus

import android.content.Context

fun putInt(context:Context ,key: String, value:Int, prefName: String = "default" ) {
    val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putInt(key, value)
        commit()
    }
}

fun getInt(context:Context,  key:String, default:Int=0, prefName:String="default"):Int {
    val sharedPref = context?.getSharedPreferences(prefName, Context.MODE_PRIVATE) ?: return default
    return sharedPref.getInt(key, default)
}