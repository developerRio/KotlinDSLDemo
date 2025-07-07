package com.originalstocks.zebpayassignment.android.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [KListRenderer] is responsible for rendering the list items.
 * */

object KListRenderer {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Render(items: List<KListItem>, padding: Dp = 16.dp) {
        val textFieldValues = remember { mutableStateMapOf<String, String>() }
        val focusManager = LocalFocusManager.current

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(vertical = 1.dp)
        ) {
            itemsIndexed(items) { index, item ->
                Column(modifier = Modifier.animateItemPlacement()) {
                    renderKListItem(item, textFieldValues, focusManager)

                    if (index < items.lastIndex) {
                        Divider(
                            thickness = 0.5.dp,
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
