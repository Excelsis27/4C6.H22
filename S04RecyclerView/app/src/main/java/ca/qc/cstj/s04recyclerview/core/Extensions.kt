package ca.qc.cstj.s04recyclerview.core

import android.widget.ImageView

fun ImageView.loadFromResource(imageName:String){
    val imageId = this.resources.getIdentifier(imageName, "drawable", context.packageName)
    this.setImageResource(imageId)
}