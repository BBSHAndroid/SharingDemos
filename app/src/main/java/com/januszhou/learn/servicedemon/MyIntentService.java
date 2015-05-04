package com.januszhou.learn.servicedemon;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by janus on 15/4/28.
 */
public class MyIntentService extends IntentService {

  public MyIntentService() {
    this( "MyIntentService" );
  }

  public MyIntentService( String name ) {
    super( name );
  }

  @Override
  public void onCreate() {
    super.onCreate();
  }

  @Override
  protected void onHandleIntent( Intent intent ) {
    Log.e( "Jzz ", "onHandleIntent called" );
    long endTime = System.currentTimeMillis() + 5 * 1000;
    while ( System.currentTimeMillis() < endTime ) {
      synchronized ( this ) {
        try {
          wait( endTime - System.currentTimeMillis() );
        } catch ( InterruptedException e ) {
          e.printStackTrace();
        }
      }
    }
    Log.e( "Jzz", "finish elapsed time task..." );
  }
}
