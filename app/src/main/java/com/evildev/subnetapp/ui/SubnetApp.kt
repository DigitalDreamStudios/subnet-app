package com.evildev.subnetapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.evildev.subnetapp.ui.components.InputForm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubnetApp() {
    // State to hold the calculated result
    var result by remember { mutableStateOf("") }

    Column {
        InputForm(
            onSubmit = { networkIp, subnetMask ->

            }
        )
    }
}

@Composable
private fun calculateSubnet(networkIp: String, subnetMask: String): String {
    return "Calculated Subnet: $networkIp/$subnetMask"
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SubnetAppPreview() {
    SubnetApp()
}
