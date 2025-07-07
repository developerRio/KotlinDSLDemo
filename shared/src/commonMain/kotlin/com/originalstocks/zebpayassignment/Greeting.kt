package com.originalstocks.zebpayassignment

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello from common main, ${platform.name}!"
    }
}