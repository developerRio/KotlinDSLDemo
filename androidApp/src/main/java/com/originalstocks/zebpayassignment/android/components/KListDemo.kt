package com.originalstocks.zebpayassignment.android.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
 * [MyKListDemo] is the final preview for the entire logic
* */

@Composable
fun MyKListDemo(innerPadding: PaddingValues) {
    val painter = rememberAsyncImagePainter("https://images.unsplash.com/photo-1658065884515-52161a2cca51?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHN1bnNldCUyMG9uJTIwbW91bnRhaW5zfGVufDB8fDB8fHww")
    val context = LocalContext.current

    Column(modifier = Modifier.padding(innerPadding)) {
        KList {
            header("A Custom KList DSL")
            text("Reusable Kotlin DSL UI builder")
            textField(id = "username", hint = "Enter Name") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
            button("Submit") {
                Toast.makeText(context, "Open this!", Toast.LENGTH_SHORT).show()
            }
            space(height = 12.dp)
            image(painter)
            image(painter)
            image(painter)
            image(painter)
        }
    }
}

