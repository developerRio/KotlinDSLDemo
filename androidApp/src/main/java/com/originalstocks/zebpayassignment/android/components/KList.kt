package com.originalstocks.zebpayassignment.android.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * KList is our DSL entry point,
 * */
@Composable
fun KList(padding: Dp = 16.dp, builderBlock: KListBuilder.() -> Unit) {
    val builder = KListBuilder().apply(builderBlock)
    KListRenderer.Render(items = builder.items, padding = padding)
}
