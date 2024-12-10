package com.my.myquote

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {
    private const val PREFS_NAME = "ThemePref"
    private const val PREF_KEY = "isDarkMode"

    fun isDarkModeEnabled(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(PREF_KEY, false)
    }

    fun toggleTheme(context: Context) {
        val isDarkMode = isDarkModeEnabled(context)
        val newMode = if (isDarkMode) AppCompatDelegate.MODE_NIGHT_NO else AppCompatDelegate.MODE_NIGHT_YES

        AppCompatDelegate.setDefaultNightMode(newMode)

        // Save preference
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(PREF_KEY, !isDarkMode).apply()
    }
}
