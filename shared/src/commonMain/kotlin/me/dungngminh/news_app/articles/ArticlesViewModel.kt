package me.dungngminh.news_app.articles

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.dungngminh.news_app.BaseViewModel

class ArticlesViewModel : BaseViewModel() {
    private val _uiState = MutableStateFlow(ArticleState.Initial)
    val uiState get() = _uiState.asStateFlow()

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }
            delay(1000)
            val articles = mockArticle()
            _uiState.update {
                it.copy(isLoading = false, articles = articles)
            }
        }
    }

    private fun mockArticle(): List<Article> {
        return listOf(
            Article(
                Source("1", "Source 1"),
                "Author 1",
                "Title 1",
                "Description 1",
                "https://www.example.com/1",
                "https://picsum.photos/400/500",
                "Content 1",
                publishedAt = "2021-10-01T00:00:00Z",
            ),
            Article(
                Source("2", "Source 2"),
                "Author 2",
                "Title 2",
                "Description 2",
                "https://www.example.com/2",
                "https://picsum.photos/400/500",
                "Content 2",
                publishedAt = "2021-10-01T00:00:00Z",
            ),
        )
    }
}
