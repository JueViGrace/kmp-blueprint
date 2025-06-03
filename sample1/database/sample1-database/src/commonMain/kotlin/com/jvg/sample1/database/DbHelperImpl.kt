package com.jvg.sample1.database

import com.jvg.kmpblueprint.database.DbHelper

/*
* Sample 1 application specific database helper.
* */
// interface Sample1DbHelper : DbHelper<Sample1DB>

class DbHelperImpl(override val db: Sample1DB) : DbHelper<Sample1DB>
