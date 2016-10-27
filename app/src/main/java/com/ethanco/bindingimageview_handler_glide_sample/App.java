package com.ethanco.bindingimageview_handler_glide_sample;

import android.app.Application;

import com.ethanco.bindingimageview.BindingImageFacade;

/**
 * Created by EthanCo on 2016/10/27.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        BindingImageFacade.init();
    }
}
