package com.jvg.kmpblueprint.database

import com.jvg.kmpblueprint.database.helper.DbHelper

interface LocalDataSource {
    val dbHelper: DbHelper<*>
}
