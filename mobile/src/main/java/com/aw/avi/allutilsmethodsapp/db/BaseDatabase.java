package com.aw.avi.allutilsmethodsapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by avinash.verma on 5/29/2017.
 */
@Database(entities = {MyDatabaseEntity.class}, version = 2, exportSchema
        = false)
public abstract class BaseDatabase extends RoomDatabase {

    private static BaseDatabase mInstance;

    public static synchronized BaseDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.
                    databaseBuilder(context.getApplicationContext(), BaseDatabase.class,
                            "recordingMergingDB")
//                    .addMigrations(MIGRATION_2_3, MIGRATION_1_2)
                    .build();
//            mInstance.populateData();
        }
        return mInstance;
    }

    @SuppressWarnings("WeakerAccess")
    public abstract MyDatabaseDAO getRecordingMerging();


//    static final Migration MIGRATION_1_2 = new Migration(5, 6) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("CREATE TABLE `" + WhiteListContactData.TABLE_NAME + "` (`id` " +
//                    "INTEGER, `name` TEXT, PRIMARY KEY(`id`))");
//        }
//    };
//
//    static final Migration MIGRATION_2_3 = new Migration(4, 5) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE " + CallRecorderData.TABLE_NAME + " " + " ADD COLUMN " +
//                    CallRecorderData.COLUMN_ALARM + " TEXT");
//
//        }
//    };


}
