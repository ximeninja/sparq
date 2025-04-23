package com.example.sparqassignment.ui.list

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.sparqassignment.data.model.Item
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(navController: NavController, viewModel: ListViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading ->  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        is UiState.Error -> {
            val message = (uiState as UiState.Error).message
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = message)
            }
        }
        is UiState.Success -> {
            val items = (uiState as UiState.Success).items
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items) { item ->
                    ItemRow(item = item) {
                        navController.navigate("detail/${item.title}/${item.description}")
                    }
                }
            }
        }
    }
}

@Composable
fun ItemRow(item: Item, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(text = item.title, style = MaterialTheme.typography.titleMedium)
    }
}
