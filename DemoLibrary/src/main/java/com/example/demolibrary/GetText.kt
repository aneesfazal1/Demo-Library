package com.example.demolibrary

import android.content.Context
import android.widget.Toast

class GetText {
    fun s(c: Context?, message: String?) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }

}



