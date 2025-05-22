package com.jvg.kmpblueprint.database.sample2

import com.jvg.kmpblueprint.database.DbHelper
import com.jvg.sample2.database.Sample2DB

/*
* Sample 2 application specific database helper.
* */
class Sample2DbHelper(override val db: Sample2DB) : DbHelper<Sample2DB>
