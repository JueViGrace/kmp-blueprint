package com.jvg.sample2.home.data

import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.kmpblueprint.home.data.SharedHomeRepository
import com.jvg.kmpblueprint.network.client.base.NetworkClient
import com.jvg.sample2.database.Sample2DB

interface HomeRepository : SharedHomeRepository

class DefaultHomeRepository(
    private val dbHelper: DbHelper<Sample2DB>,
    private val client: NetworkClient
) : HomeRepository
