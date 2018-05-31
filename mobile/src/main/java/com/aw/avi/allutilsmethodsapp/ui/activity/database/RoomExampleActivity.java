package com.aw.avi.allutilsmethodsapp.ui.activity.database;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.db.BaseDatabase;
import com.aw.avi.allutilsmethodsapp.db.MyDatabaseDAO;
import com.aw.avi.allutilsmethodsapp.db.MyDatabaseEntity;

public class RoomExampleActivity extends AppCompatActivity {

    private BaseDatabase baseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_example);

        baseDatabase = BaseDatabase.getInstance(this);

        MyDatabaseDAO myDatabaseDAO = baseDatabase.getRecordingMerging();


        myDatabaseDAO.getRxSingleData(2);

    }


    class InsertAsync extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            MyDatabaseDAO myDatabaseDAO = baseDatabase.getRecordingMerging();

            MyDatabaseEntity myDatabaseEntity=new MyDatabaseEntity();
            myDatabaseEntity.audioTranscribeLanguage="";

            myDatabaseDAO.insert(myDatabaseEntity);

            return null;
        }
    }

}
