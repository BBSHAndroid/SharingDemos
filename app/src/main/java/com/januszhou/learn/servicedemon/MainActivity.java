package com.januszhou.learn.servicedemon;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

  Button startButton;
  Button stopButton;
  Button bindButton;
  Button unbindButton;

  MyService mMyService;

  MyServiceConnection mMyServiceConnection = new MyServiceConnection();

  private IRemoteService mIRemoteService;

  class MyServiceConnection implements ServiceConnection {

    @Override
    public void onServiceConnected( ComponentName name, IBinder service ) {
      Log.e( "Jzz", "onServiceConnected" );
//      mMyService = ((MyService.LocalBinder)service).getService();
//      Log.d( "Jzz", mMyService.helloworld() );
      mIRemoteService = IRemoteService.Stub.asInterface( service );
      try {
        Log.d( "Jzz", mIRemoteService.helloworld() );
      }catch ( RemoteException e ) {
        e.printStackTrace();
      }
    }

    @Override
    public void onServiceDisconnected( ComponentName name ) {
      Log.e( "Jzz", "onServiceDisconnected" );
    }
  }

  @Override
  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );

    startButton = ( Button ) findViewById( R.id.start );
    stopButton = ( Button ) findViewById( R.id.stop );
    bindButton = ( Button ) findViewById( R.id.bind );
    unbindButton = ( Button ) findViewById( R.id.unbind );

    startButton.setOnClickListener( this );
    stopButton.setOnClickListener( this );
    bindButton.setOnClickListener( this );
    unbindButton.setOnClickListener( this );

  }


  @Override
  public boolean onCreateOptionsMenu( Menu menu ) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate( R.menu.menu_main, menu );
    return true;
  }

  @Override
  public boolean onOptionsItemSelected( MenuItem item ) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if ( id == R.id.action_settings ) {
      return true;
    }

    return super.onOptionsItemSelected( item );
  }

  @Override
  public void onClick( View v ) {
    switch ( v.getId() ) {
      case R.id.start:
        startService( new Intent( this, MyService.class ) );
        break;
      case R.id.stop:
        stopService( new Intent( this, MyService.class ) );
        break;
      case R.id.bind:
        bindService( new Intent( this, AIDLService.class ), mMyServiceConnection, BIND_AUTO_CREATE );
        break;
      case R.id.unbind:
        unbindService( mMyServiceConnection );
        break;
    }
  }
}
