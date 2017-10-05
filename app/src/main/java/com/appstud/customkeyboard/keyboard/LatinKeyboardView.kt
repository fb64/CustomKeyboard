/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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

import android.content.Context
import android.inputmethodservice.Keyboard
import android.inputmethodservice.Keyboard.Key
import android.inputmethodservice.KeyboardView
import android.util.AttributeSet
import android.view.inputmethod.InputMethodSubtype

class LatinKeyboardView : KeyboardView {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun onLongPress(key: Key): Boolean {
        if (key.codes[0] == Keyboard.KEYCODE_CANCEL) {
            onKeyboardActionListener.onKey(KEYCODE_OPTIONS, null)
            return true
        } else {
            return super.onLongPress(key)
        }
    }

    internal fun setSubtypeOnSpaceKey(subtype: InputMethodSubtype) {
        val keyboard = keyboard as LatinKeyboard
        keyboard.setSpaceIcon(resources.getDrawable(subtype.iconResId))
        invalidateAllKeys()
    }

    companion object {

        internal val KEYCODE_OPTIONS = -100
        // TODO: Move this into android.inputmethodservice.Keyboard
        internal val KEYCODE_LANGUAGE_SWITCH = -101
    }
}
