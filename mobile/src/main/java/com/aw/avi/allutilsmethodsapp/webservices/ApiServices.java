package com.aw.avi.allutilsmethodsapp.webservices;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by avinash.verma on 12/18/2017.
 */

public class ApiServices {

    private Retrofit retrofit;
    private RetroInterface retroInterface;
    private Observer observer;

    public ApiServices(Observer observer, String baseURL) {
        this.retrofit = retrofit;
        this.retroInterface = retroInterface;
        this.observer = observer;
    }

    public void demoMethod(){
        retroInterface.getDemoMethod()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .take(1)
                .subscribe(observer);
    }


}
