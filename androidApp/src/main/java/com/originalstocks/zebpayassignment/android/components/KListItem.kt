package com.originalstocks.zebpayassignment.android.components

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp

/**
 * All Item Types have been created here, consumed in [KListBuilder], [KListRenderer] and [KList] composables.
 * */
sealed class KListItem {
    data class Space(val height: Dp) : KListItem()
    data class Header(val text: String) : KListItem()
    data class Text(val text: String) : KListItem()
    data class Image(val painter: Painter) : KListItem()
    data class Button(val text: String, val onClick: () -> Unit) : KListItem()
    data class TextField(val id: String, val hint: String, val onValueChanged: (String) -> Unit) : KListItem()
}