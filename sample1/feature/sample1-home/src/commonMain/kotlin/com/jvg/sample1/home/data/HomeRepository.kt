package com.jvg.sample1.home.data

import com.jvg.kmpblueprint.api.client.base.NetworkClient
import com.jvg.kmpblueprint.database.DbHelper
import com.jvg.kmpblueprint.home.data.SharedHomeRepository
import com.jvg.sample1.database.Sample1DB

interface HomeRepository : SharedHomeRepository

class DefaultHomeRepository(
    override val dbHelper: DbHelper<Sample1DB>,
    override val client: NetworkClient
) : HomeRepository
