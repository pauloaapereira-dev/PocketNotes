package com.pp.pocketnotes.presentation.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pp.pocketnotes.presentation.theme.PocketNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PocketActivity : ComponentActivity() {

    private val viewModel by viewModels<PocketViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketNotesTheme {
                Screen(viewModel.pocketState)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadPocketItems()
    }
}

@Composable
fun Screen(pocketViewState: PocketViewState) {
    val ctx = LocalContext.current

    Surface(color = MaterialTheme.colorScheme.background) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            when (pocketViewState) {
                is PocketViewState.Loaded -> {
                    if (pocketViewState.pocketItems.isEmpty()) {
                        Text(text = "Empty!")
                    } else {
                        LazyColumn {
                            items(pocketViewState.pocketItems) {
                                Button(onClick = { ctx.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it.uri))) }) {
                                    Text(text = "item!")
                                }
                            }
                        }
                    }
                }
                PocketViewState.Error -> TODO()
                PocketViewState.Loading -> {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary,
                        strokeWidth = 2.dp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PocketNotesTheme {
        Screen(PocketViewState.Loading)
    }
}