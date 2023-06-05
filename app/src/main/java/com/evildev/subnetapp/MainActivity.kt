package com.evildev.subnetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.evildev.subnetapp.ui.SubnetApp
import com.evildev.subnetapp.ui.components.AppHeader
import com.evildev.subnetapp.ui.theme.SubnetAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubnetAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppHeader(
                        content = {
                            Box(modifier = Modifier.fillMaxSize()) {
                                SubnetApp()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAppHeader() {
    AppHeader(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                SubnetApp()
            }
        }
    )
}