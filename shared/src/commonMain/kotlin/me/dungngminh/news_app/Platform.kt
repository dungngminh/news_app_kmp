package me.dungngminh.news_app

expect class Platform {

    val osName: String

    val osVersion: String

    val deviceModel: String

    val density: Int

    fun logSystemInfo()
}