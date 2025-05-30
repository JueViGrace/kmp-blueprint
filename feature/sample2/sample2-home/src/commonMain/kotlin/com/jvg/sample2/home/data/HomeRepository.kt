package com.jvg.sample2.home.data

import com.jvg.kmpblueprint.api.client.NetworkClient
import com.jvg.kmpblueprint.database.DbHelper
import com.jvg.kmpblueprint.home.data.SharedHomeRepository
import com.jvg.sample2.database.Sample2DB

interface HomeRepository : SharedHomeRepository

class DefaultHomeRepository(
    override val dbHelper: DbHelper<Sample2DB>,
    override val client: NetworkClient
) : HomeRepository
