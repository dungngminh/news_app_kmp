package me.dungngminh.news_app.articles

data class Article(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val content: String?,
    val publishedAt: String?,
)
