package com.evildev.subnetapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.evildev.subnetapp.data.NetworkData
import com.evildev.subnetapp.ui.components.InputForm
import com.evildev.subnetapp.ui.components.OutputForm
import kotlin.math.pow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubnetApp() {
    // State to hold the calculated result
    var result by remember { mutableStateOf<NetworkData?>(null) }

    Column {
        InputForm(
            onSubmit = { networkIp, subnetMask ->
                val calculationResult = calculateSubnet(networkIp, subnetMask)
                result = calculationResult
            }
        )
        result?.let { outputResult ->
            OutputForm(
                networkIp = outputResult.networkIp,
                firstIp = outputResult.firstIp,
                lastIp = outputResult.lastIp,
                broadcast = outputResult.broadcast,
                hostQuantity = outputResult.hostQuantity,
                onButtonClick = { result = null }
            )
        }
    }
}

private fun calculateSubnet(networkIp: String, subnetMask: String): NetworkData? {
    val networkParts = networkIp.split('.')
    val maskParts = subnetMask.split('.')

    // Validate IP and mask
    if (networkParts.size != 4 || maskParts.size != 4) {
        return null
    }

    val network = mutableListOf<Int>()
    val ip = mutableListOf<Int>()
    val broadcast = mutableListOf<Int>()

    // Calculate with binary operations
    for (i in 0 until 4) {
        ip.add(networkParts[i].toInt())
        network.add(networkParts[i].toInt() and maskParts[i].toInt())
        broadcast.add(networkParts[i].toInt() or (255 - maskParts[i].toInt()))
    }

    // Calculate the first and last IP
    val firstIpParts = ip.mapIndexed { index, value ->
        if (index == 3) value + 1 else value
    }
    val lastIpParts = broadcast.mapIndexed { index, value ->
        if (index == 3) value - 1 else value
    }

    // Convert IP parts to strings
    val networkIp = network.joinToString(".")
    val firstIp = firstIpParts.joinToString(".")
    val lastIp = lastIpParts.joinToString(".")
    val broadcastIp = broadcast.joinToString(".")

    // Calculate host quantity
    val hostQuantity = 2.0.pow(32 - countSetBits(subnetMask)).toInt() - 2

    return NetworkData(
        networkIp = networkIp,
        firstIp = firstIp,
        lastIp = lastIp,
        broadcast = broadcastIp,
        hostQuantity = hostQuantity.toString()
    )
}

private fun countSetBits(subnetMask: String): Int {
    val maskParts = subnetMask.split('.')
    var count = 0
    for (i in 0 until 4) {
        count += Integer.bitCount(maskParts[i].toInt())
    }
    return count
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SubnetAppPreview() {
    SubnetApp()
}
