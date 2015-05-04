package com.januszhou.learn.servicedemon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by janus on 15/4/29.
 */
public class AIDLService extends Service {

  private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
    @Override
    public String helloworld() throws RemoteException {
      return "Hello world!";
    }

  };

  @Override
  public void onCreate() {
    super.onCreate();
  }

  @Override
  public IBinder onBind( Intent intent ) {
    return mBinder;
  }

  @Override
  public int onStartCommand( Intent intent, int flags, int startId ) {
    return super.onStartCommand( intent, flags, startId );
  }
}
