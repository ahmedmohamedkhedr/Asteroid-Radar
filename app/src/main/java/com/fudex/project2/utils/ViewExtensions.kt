package com.fudex.project2.utils

import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.system.Os.accept
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.fudex.project2.R
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(Uri.parse(url))
        .into(this)
}

fun Context.showDialog(message: String) {
    AlertDialog.Builder(this)
        .setMessage(message)

        .setPositiveButton(
            R.string.accept
        ) { dialog, int ->
            dialog.dismiss()
        }
        .show()
}