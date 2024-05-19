package me.dungngminh.news_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform