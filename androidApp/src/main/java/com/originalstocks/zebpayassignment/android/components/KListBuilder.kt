package com.originalstocks.zebpayassignment.android.components

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp

/**
 * [KListBuilder] is used to build the list items., customized with DSL., we can add as many items as we want such as space, text, image, button, etc.
 * */
class KListBuilder(
    internal val items: MutableList<KListItem> = mutableListOf()
) {
    fun space(height: Dp) = apply { items.add(KListItem.Space(height)) } // not used in this demo for now
    fun header(text: String) = apply { items.add(KListItem.Header(text)) }
    fun text(text: String) = apply { items.add(KListItem.Text(text)) }
    fun image(painter: Painter) = apply { items.add(KListItem.Image(painter)) }
    fun button(text: String, onClick: () -> Unit) = apply { items.add(KListItem.Button(text, onClick)) }
    fun textField(id: String, hint: String, onValueChanged: (String) -> Unit) =
        apply { items.add(KListItem.TextField(id, hint, onValueChanged)) }
}