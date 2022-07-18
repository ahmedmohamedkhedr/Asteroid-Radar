package com.fudex.project2.presentation.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.fudex.project2.R


@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("absoluteMagnitudeText")
fun bindTextViewToAbsoluteMagnitude(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("estimatedDiameterMaxText")
fun bindTextViewToEstimatedDiameterMax(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("kilometersPerSecondText")
fun bindTextViewToKilometersPerSecond(textView: TextView, number: String) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number.toDouble())
}

@BindingAdapter("astronomicalText")
fun bindTextViewToAstronomical(textView: TextView, number: String) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number.toDouble())
}


