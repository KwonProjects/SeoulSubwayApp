package co.kr.kwon.seoulsubwayapp.extension

import android.view.View
import androidx.annotation.Px
import co.kr.kwon.seoulsubwayapp.extension.dip

@Px
fun View.dip(dipValue: Float) = context.dip(dipValue)

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}
