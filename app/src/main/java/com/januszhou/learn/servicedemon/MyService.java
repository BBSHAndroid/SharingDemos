package com.januszhou.learn.servicedemon;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by janus on 15/4/28.
 */
public class MyService extends Service {

  private final IBinder mIBinder = new LocalBinder();

  public class LocalBinder extends Binder {
    MyService getService() {
      // Return this instance of LocalService so clients can call public methods
      return MyService.this;
    }
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Log.e("Jzz", "onCreate");
  }

  @Override
  public int onStartCommand( Intent intent, int flags, int startId ) {
    Log.e("Jzz", "onStartCommand");
    return super.onStartCommand( intent, flags, startId );
  }

  @Override
  public void onStart( Intent intent, int startId ) {
    super.onStart( intent, startId );
    Log.e("Jzz", "onStart");
  }

  @Override
  public IBinder onBind( Intent intent ) {
    Log.e("Jzz", "onBind");
    return mIBinder;
  }

  @Override
  public boolean onUnbind( Intent intent ) {
    Log.e("Jzz", "onUnbind");
    return super.onUnbind( intent );
  }

  @Override
  public void onRebind( Intent intent ) {
    Log.e("Jzz", "onRebind");
    super.onRebind( intent );
  }

  @Override
  public void onDestroy() {
    Log.e("Jzz", "onDestroy");
    super.onDestroy();
  }

  public String helloworld() {
    return "hello world!";
  }
}
