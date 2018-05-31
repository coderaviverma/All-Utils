package com.aw.avi.allutilsmethodsapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by avinash.verma on 8/31/2017.
 */

@Dao
public interface MyDatabaseDAO {


    @Query("SELECT * FROM " + MyDatabaseEntity.TABLE_NAME + " WHERE " + MyDatabaseEntity
            .COLUMN_GROUP_ID + " IN (:groupid) AND " + MyDatabaseEntity.COLUMN_SEGMENT_ID + "" +
            " IN (:segmentid)" + " ORDER BY " + MyDatabaseEntity.COLUMN_SAVING_DATETIME + " " +
            "DESC")
    List<MyDatabaseEntity> getRecordMergingRecord(int groupid, int segmentid);


    @Query("SELECT COUNT(*) FROM " + MyDatabaseEntity.TABLE_NAME)
    int count();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MyDatabaseEntity mergingData);


    @Query("SELECT * FROM " + MyDatabaseEntity.TABLE_NAME + " WHERE " + MyDatabaseEntity
            .COLUMN_ID + " IN (:columnid)")
    MyDatabaseEntity getRecordMergingFromID(int columnid);

    @Query("SELECT * FROM " + MyDatabaseEntity.TABLE_NAME + " WHERE " + MyDatabaseEntity
            .COLUMN_FULL_AUDIO_FILE_PATH + " IN (:filepath)")
    MyDatabaseEntity getRecordMergingFromPath(String filepath);


    @Query("SELECT " + MyDatabaseEntity.COLUMN_WATSON_STARTED + " FROM " + MyDatabaseEntity.TABLE_NAME + " WHERE "
            + MyDatabaseEntity.COLUMN_FULL_AUDIO_FILE_PATH + " IN (:filepath)")
    boolean getAudioTranscribeStarted(String filepath);


    @Query("SELECT " + MyDatabaseEntity.COLUMN_AUDIO_TRANSCRIBE_LANGUAGE + " FROM " + MyDatabaseEntity.TABLE_NAME + " " +
            "WHERE " + MyDatabaseEntity.COLUMN_FULL_AUDIO_FILE_PATH + " IN (:filepath)")
    String getAudioTranscribeLanguage(String filepath);


    @Query("SELECT " + MyDatabaseEntity.COLUMN_AUDIO_TRANSCRIBE_BY_WATSON + " FROM " + MyDatabaseEntity.TABLE_NAME + " " +
            "WHERE " + MyDatabaseEntity.COLUMN_FULL_AUDIO_FILE_PATH + " IN (:filepath)")
    String getAudioTranscribeForAudioFile(String filepath);


    @Delete
    void delete(MyDatabaseEntity mergingData);

    @Update
    public void updateCallRecord(MyDatabaseEntity... mergingData);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(MyDatabaseEntity... mergingData);


    @Query("SELECT * FROM " + MyDatabaseEntity.TABLE_NAME + " WHERE " + MyDatabaseEntity
            .COLUMN_ID + " IN (:columnid)")
    Maybe<MyDatabaseEntity> getRxMaybeData(int columnid);

    @Query("SELECT * FROM " + MyDatabaseEntity.TABLE_NAME + " WHERE " + MyDatabaseEntity
            .COLUMN_ID + " IN (:columnid)")
    Single<MyDatabaseEntity> getRxSingleData(int columnid);


}
