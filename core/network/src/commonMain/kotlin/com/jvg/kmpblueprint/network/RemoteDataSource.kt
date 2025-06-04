package com.jvg.kmpblueprint.network

import com.jvg.kmpblueprint.network.client.base.NetworkClient

interface RemoteDataSource {
    val client: NetworkClient
}
