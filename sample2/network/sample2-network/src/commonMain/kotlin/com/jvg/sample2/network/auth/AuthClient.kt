package com.jvg.sample2.network.auth

import com.jvg.kmpblueprint.network.auth.SharedAuthClient
import com.jvg.kmpblueprint.network.client.base.NetworkClient

interface AuthClient : SharedAuthClient

class DefaultAuthClient(override val client: NetworkClient) : AuthClient