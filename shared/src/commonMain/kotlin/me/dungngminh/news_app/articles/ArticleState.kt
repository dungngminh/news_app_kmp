package me.dungngminh.news_app.articles

data class ArticleState(
    val isLoading: Boolean,
    val articles: List<Article>,
    val error: String?,
) {
    companion object {
        val Initial =
            ArticleState(
                isLoading = false,
                articles = emptyList(),
                error = null,
            )
    }
}
