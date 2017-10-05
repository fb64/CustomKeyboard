/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appstud.customkeyboard.keyboard

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import com.appstud.customkeyboard.R
import com.appstud.customkeyboard.settings.InputMethodSettingsFragment


/**
 * Displays the IME preferences inside the input method setting.
 */
class ImePreferences : PreferenceActivity() {
    override fun getIntent(): Intent {
        val modIntent = Intent(super.getIntent())
        modIntent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT, Settings::class.java.name)
        modIntent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true)
        return modIntent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We overwrite the title of the activity, as the default one is "Voice Search".
        setTitle(R.string.settings_name)
    }

    override fun isValidFragment(fragmentName: String): Boolean {
        return Settings::class.java.name == fragmentName
    }

    class Settings : InputMethodSettingsFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            super.onCreate(savedInstanceState)
            setInputMethodSettingsCategoryTitle(R.string.language_selection_title)
            setSubtypeEnablerTitle(R.string.select_language)

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.ime_preferences)
        }
    }
}
