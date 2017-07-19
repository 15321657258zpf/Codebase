package com.ganxin.codebase.application;

import android.app.Application;
import android.content.Context;

import com.ganxin.codebase.crash.CrashHandler;
import com.ganxin.codebase.utils.sdcard.StorageManager;

/**
 * Description : Application  <br/>
 * author : WangGanxin <br/>
 * date : 2016/9/4 <br/>
 * email : ganxinvip@163.com <br/>
 */
public class CodebaseApplication extends Application {

    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppContext=this;

        //在这里为应用设置异常处理程序，然后我们的程序才能捕获未处理的异常
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        initStorage();
    }

    private void initStorage() {
        StorageManager.getInstance().setAppContext(mAppContext);
        StorageManager.getInstance().setRootDir(ConstantValues.DIR_ROOT);
        StorageManager.getInstance().setImageDir(ConstantValues.DIR_PICTURE);
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
