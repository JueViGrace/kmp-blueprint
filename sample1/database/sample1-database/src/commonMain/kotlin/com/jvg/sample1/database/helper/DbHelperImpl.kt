package com.jvg.sample1.database.helper

import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.sample1.database.Sample1DB

/*
* Sample 1 application specific database helper.
* */
class DbHelperImpl(override val db: Sample1DB) : DbHelper<Sample1DB>
