package com.telephony;

import android.app.Application;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rafael on 03/07/17.
 */

public class TelephonyPackage implements ReactPackage {

    private Application applicationInstance;

    public TelephonyPackage(Application applicationInstance) {
        super();
        this.applicationInstance = applicationInstance;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        TelephonyModule telephonyCallStateModule = new TelephonyModule(reactContext);

        applicationInstance.registerActivityLifecycleCallbacks(telephonyCallStateModule);

        modules.add(telephonyCallStateModule);

        return modules;
    }
}