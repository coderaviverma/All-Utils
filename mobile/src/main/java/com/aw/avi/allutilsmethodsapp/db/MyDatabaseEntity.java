package com.aw.avi.allutilsmethodsapp.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;

/**
 * Created by avinash.verma on 8/31/2017.
 */

@Entity(tableName = MyDatabaseEntity.TABLE_NAME)
public class MyDatabaseEntity {


    public static final String TABLE_NAME = "edsRecordingMerging";

    /**
     * The name of the ID column.
     */
    public static final String COLUMN_ID = BaseColumns._ID;

    /**
     * The name of the ID column.
     */
    public static final String COLUMN_GROUP_ID = "groupID";

    /**
     * The name of the ID column.
     */
    public static final String COLUMN_SEGMENT_ID = "segmentID";

    /**
     * The name of Full Recorded File PATH Number Column
     */
    public static final String COLUMN_FULL_AUDIO_FILE_PATH = "full_audio_file";

    /**
     * The name of Full Recorded File PATH Number Column
     */
    public static final String COLUMN_MERGE_AUDIO_FILE_PATH = "merge_audio_file";

    /**
     * The name of Full Recorded File PATH Number Column
     */
    public static final String COLUMN_MERGE_AUDIO_FILE_NAME = "merge_audio_file_name";

    /**
     * The name of Full Recorded File PATH Number Column
     */
    public static final String COLUMN_FULL_AUDIO_FILE_NAME = "full_audio_file_name";

    /**
     * The name of Full Recorded File PATH Number Column
     */
    public static final String COLUMN_SAVING_DATETIME = "saving_datetime";


    /**
     * The Coloumn name of Audio Transcribe from IBM Watson
     */
    public static final String COLUMN_AUDIO_TRANSCRIBE_BY_WATSON = "audio_transcribe";

    /**
     * The Coloumn name of Audio Transcribe from IBM Watson
     */
    public static final String COLUMN_AUDIO_TRANSCRIBE_LANGUAGE = "audio_transcribe_language";

    /**
     * The Coloumn name of Audio Transcribe from IBM Watson
     */
    public static final String COLUMN_WATSON_STARTED = "watson_started";


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    public long id;


    @ColumnInfo(name = COLUMN_GROUP_ID)
    public long groupID;

    @ColumnInfo(name = COLUMN_SEGMENT_ID)
    public long segmentID;

    @ColumnInfo(name = COLUMN_FULL_AUDIO_FILE_PATH)
    public String fullAudioPath;

    @ColumnInfo(name = COLUMN_SAVING_DATETIME)
    public long savingDateTimeMillis;

    @ColumnInfo(name = COLUMN_MERGE_AUDIO_FILE_PATH)
    public String mergeAudioPath;

    @ColumnInfo(name = COLUMN_MERGE_AUDIO_FILE_NAME)
    public String mergeAudioName;

    @ColumnInfo(name = COLUMN_FULL_AUDIO_FILE_NAME)
    public String fullAudioName;

    @ColumnInfo(name = COLUMN_WATSON_STARTED)
    public boolean watsonStarted;

    @ColumnInfo(name = COLUMN_AUDIO_TRANSCRIBE_LANGUAGE)
    public String audioTranscribeLanguage;

    @ColumnInfo(name = COLUMN_AUDIO_TRANSCRIBE_BY_WATSON)
    public String watsonAudioTranscribe;

    public String getMergeAudioName() {
        return mergeAudioName;
    }

    public void setMergeAudioName(String mergeAudioName) {
        this.mergeAudioName = mergeAudioName;
    }

    public String getFullAudioName() {
        return fullAudioName;
    }

    public void setFullAudioName(String fullAudioName) {
        this.fullAudioName = fullAudioName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public long getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(long segmentID) {
        this.segmentID = segmentID;
    }

    public String getFullAudioPath() {
        return fullAudioPath;
    }

    public void setFullAudioPath(String fullAudioPath) {
        this.fullAudioPath = fullAudioPath;
    }

    public long getSavingDateTimeMillis() {
        return savingDateTimeMillis;
    }

    public void setSavingDateTimeMillis(long savingDateTimeMillis) {
        this.savingDateTimeMillis = savingDateTimeMillis;
    }

    public String getWatsonAudioTranscribe() {
        return watsonAudioTranscribe;
    }

    public void setWatsonAudioTranscribe(String watsonAudioTranscribe) {
        this.watsonAudioTranscribe = watsonAudioTranscribe;
    }

    public String getAudioTranscribeLanguage() {
        return audioTranscribeLanguage;
    }

    public void setAudioTranscribeLanguage(String audioTranscribeLanguage) {
        this.audioTranscribeLanguage = audioTranscribeLanguage;
    }

    public boolean isWatsonStarted() {
        return watsonStarted;
    }

    public void setWatsonStarted(boolean watsonStarted) {
        this.watsonStarted = watsonStarted;
    }

    public String getMergeAudioPath() {
        return mergeAudioPath;
    }

    public void setMergeAudioPath(String mergeAudioPath) {
        this.mergeAudioPath = mergeAudioPath;
    }
}
