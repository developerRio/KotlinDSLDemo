package com.originalstocks.zebpayassignment

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform