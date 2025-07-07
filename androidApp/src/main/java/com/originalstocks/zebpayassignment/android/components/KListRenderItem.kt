package com.originalstocks.zebpayassignment.android.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale

@Composable
internal fun renderKListItem(
    item: KListItem,
    textFieldValues: MutableMap<String, String>,
    focusManager: FocusManager
) {
    val context = LocalContext.current

    when (item) {
        is KListItem.Space -> Spacer(modifier = Modifier.height(item.height))

        is KListItem.Header -> Text(
            text = item.text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        is KListItem.Text -> Text(
            text = item.text,
            fontSize = 16.sp,
            modifier = Modifier.padding(4.dp)
        )

        is KListItem.Image -> Image(
            painter = item.painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(vertical = 8.dp),
            contentScale = ContentScale.Crop
        )

        is KListItem.Button -> Button(
            onClick = {
                item.onClick()
                Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(item.text)
        }

        is KListItem.TextField -> {
            val value = textFieldValues[item.id] ?: ""
            OutlinedTextField(
                value = value,
                onValueChange = {
                    textFieldValues[item.id] = it
                    item.onValueChanged(it)
                },
                label = { Text(item.hint) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                })
            )
        }
    }
}
