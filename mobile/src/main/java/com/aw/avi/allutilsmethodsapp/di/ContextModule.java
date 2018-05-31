package com.aw.avi.allutilsmethodsapp.di;

import android.content.Context;

/**
 * Created by avinash.verma on 3/26/2018.
 */


public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

//
//    @Provides
//    Context context() {
//        return context;
//    }

}
