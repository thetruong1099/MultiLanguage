package com.example.multilanguage

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) {
        val sharedPreferences = newBase.getSharedPreferences("Data", Context.MODE_PRIVATE)
        val localeToSwitchTo = sharedPreferences.getString("locale", "en") ?: "en"
        val localeUpdatedContext: ContextWrapper =
            ContextUtils.updateLocale(newBase, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)
    }

}