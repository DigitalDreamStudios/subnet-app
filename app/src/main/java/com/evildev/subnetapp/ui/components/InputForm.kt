package com.evildev.subnetapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputForm(
    onSubmit: (String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        var networkIp by remember { mutableStateOf("") }
        var subnetMask by remember { mutableStateOf("") }

        TextField(
            value = networkIp,
            onValueChange = { networkIp = it },
            label = { Text("Network IP") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = subnetMask,
            onValueChange = { subnetMask = it },
            label = { Text("Subnet Mask") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = { onSubmit(networkIp, subnetMask) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Calculate")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InputFormPreview() {
    InputForm(
        onSubmit = { _, _ -> }
    )
}