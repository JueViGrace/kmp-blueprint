package com.jvg.sample1.home.data

import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.kmpblueprint.home.data.SharedHomeRepository
import com.jvg.kmpblueprint.network.client.base.NetworkClient
import com.jvg.sample1.database.Sample1DB

interface HomeRepository : SharedHomeRepository

class DefaultHomeRepository(
    private val dbHelper: DbHelper<Sample1DB>,
    private val client: NetworkClient
) : HomeRepository
