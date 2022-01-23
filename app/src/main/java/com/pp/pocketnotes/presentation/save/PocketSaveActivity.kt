package com.pp.pocketnotes.presentation.save

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PocketSaveActivity : AppCompatActivity() {

    private val viewModel by viewModels<PocketSaveViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handleShareIntent()
        observeSavingState()
    }

    private fun observeSavingState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.savingState.collectLatest { state ->
                    handleState(state)
                }
            }
        }
    }

    private fun handleState(state: PocketSavingState) {
        when (state) {
            PocketSavingState.Success -> {
                Toast.makeText(this, "Successfully saved to your pocket!", Toast.LENGTH_SHORT).show()
                finish()
            }
            PocketSavingState.Failure -> {
                Toast.makeText(this, "It seems there was an error saving the item to your pocket.", Toast.LENGTH_SHORT).show()
                finish()
            }
            PocketSavingState.Idle -> {}
        }
    }

    private fun handleShareIntent() {
        with (intent) {
            if (action != Intent.ACTION_SEND) return

            val data = intent.clipData?.getItemAt(0) ?: return
            val mimeType = intent.clipData?.description?.getMimeType(0) ?: return

            val uri = when (mimeType) {
                "text/plain" -> data.text
                else -> data.uri?.path
            }?.toString()

            uri?.let {
                viewModel.savePocketItem(it)
            }
        }
    }
}