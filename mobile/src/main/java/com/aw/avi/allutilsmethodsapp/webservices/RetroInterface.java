package com.aw.avi.allutilsmethodsapp.webservices;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by avinash.verma on 12/18/2017.
 */

public interface RetroInterface {

    @GET("/api/data/coinlist")
    Observable<String> getDemoMethod();


//    http://www.codexpedia.com/android/retrofit-2-and-rxjava-for-file-downloading-in-android/
}
