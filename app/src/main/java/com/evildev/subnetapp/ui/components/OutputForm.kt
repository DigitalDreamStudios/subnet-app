package com.evildev.subnetapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutputForm(
    networkIp: String,
    firstIp: String,
    lastIp: String,
    broadcast: String,
    hostQuantity: String,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = networkIp,
            onValueChange = { /* No-op since it's read-only */ },
            label = { Text("Network Address") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        TextField(
            value = firstIp,
            onValueChange = { /* No-op since it's read-only */ },
            label = { Text("First IP") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        TextField(
            value = lastIp,
            onValueChange = { /* No-op since it's read-only */ },
            label = { Text("Last IP") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )
        TextField(
            value = broadcast,
            onValueChange = { /* No-op since it's read-only */ },
            label = { Text("Broadcast") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        TextField(
            value = hostQuantity,
            onValueChange = { /* No-op since it's read-only */ },
            label = { Text("Host Quantity") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            enabled = false
        )

        Button(
            onClick = onButtonClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Clear")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OutputFormPreview() {
    OutputForm(
        networkIp = "192.168.0.0",
        firstIp = "192.168.0.1",
        lastIp = "192.168.0.254",
        broadcast = "192.168.0.255",
        hostQuantity = "254",
        onButtonClick = { /* Handle button click */ }
    )
}