package com.jvg.kmpblueprint.database.sample1

import com.jvg.kmpblueprint.database.DbHelper
import com.jvg.sample1.database.Sample1DB

/*
* Sample 1 application specific database helper.
* */
class Sample1DbHelper(override val db: Sample1DB) : DbHelper<Sample1DB>
