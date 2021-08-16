package ru.gb.gb_popular_libs.data.storage.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object GitHub1to2Migration : Migration(1, 2) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE github_user ADD COLUMN migrate TEXT DEFAULT NULL")
    }

}