package me.dungngminh.news_app.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import me.dungngminh.news_app.android.MyApplicationTheme
import me.dungngminh.news_app.android.R
import me.dungngminh.news_app.articles.Article
import me.dungngminh.news_app.articles.ArticlesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticlesViewModel,
) {
    val articleState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = {
                Text(text = "Article Screen")
            })
        },
    ) { innerPadding ->
        if (articleState.isLoading) {
            Loader(modifier = Modifier.padding(innerPadding))
        } else if (articleState.error != null) {
            ErrorView(
                modifier = Modifier.padding(innerPadding),
                error = articleState.error.orEmpty(),
            )
        } else {
            ArticleList(
                modifier = Modifier.padding(innerPadding),
                articles = articleState.articles,
            )
        }
    }
}

@Composable
fun Loader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    error: String,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = error)
    }
}

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
) {
    if (articles.isEmpty()) {
        Text(text = "No articles found")
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            items(articles) { article ->
                ArticleItem(article = article)
            }
        }
    }
}

@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    article: Article,
) {
    Column(
        modifier =
            modifier
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp),
    ) {
        AsyncImage(
            model = article.urlToImage,
            contentDescription = null,
            modifier =
                Modifier.fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.img_placeholder),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            article.title.orEmpty(),
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            article.description.orEmpty(),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
private fun ArticleItem_Preview() {
    MyApplicationTheme {
        ArticleItem(
            article =
                Article(
                    source = null,
                    author = "Author",
                    title = "Title",
                    description = "Description",
                    url = "Url",
                    urlToImage = "https://picsum.photos/400/500",
                    content = "Content",
                    publishedAt = "Published At",
                ),
        )
    }
}
