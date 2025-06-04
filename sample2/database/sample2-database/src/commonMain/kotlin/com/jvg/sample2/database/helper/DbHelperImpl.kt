package com.jvg.sample2.database.helper

import app.cash.sqldelight.async.coroutines.synchronous
import com.jvg.kmpblueprint.database.driver.DriverFactory
import com.jvg.kmpblueprint.database.helper.DbHelper
import com.jvg.sample2.database.Sample2DB

/*
* Sample 2 application specific database helper.
* */
class DbHelperImpl(
    driverFactory: DriverFactory,
) : DbHelper<Sample2DB> {
    /*
     * NOTE: because Sample 2 application only targets Android and Ios platforms
     *       I think it's okay initializing the database here, otherwise it should
     *       be defined in the dependency injection module or mark this class as expect
     *       and create an implementation in each platform.
     * */
    override val db: Sample2DB =
        Sample2DB.Companion(
            driverFactory.createDriver(
                Sample2DB.Schema.synchronous(),
                "sample2.db"
            )
        )
}
