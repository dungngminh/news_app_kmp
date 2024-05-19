package me.dungngminh.news_app.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.dungngminh.news_app.Platform

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ScreenAppBar()
        },
    ) { innerPadding ->
        ContentView(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAppBar(modifier: Modifier = Modifier) {
    TopAppBar(modifier = modifier, title = {
        Text("About Screen")
    })
}

@Composable
private fun ContentView(modifier: Modifier = Modifier) {
    val items = createItems()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items) {
            InfoViewItem(
                title = it.first,
                content = it.second,
            )
        }
    }
}

@Composable
fun InfoViewItem(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
) {
    Column(modifier = modifier) {
        Text(
            title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            content,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

private fun createItems(): List<Pair<String, String>> {
    val platform = Platform()
    return listOf(
        "OS Name" to platform.osName,
        "OS Version" to platform.osVersion,
        "Device Density" to platform.density.toString(),
    )
}
