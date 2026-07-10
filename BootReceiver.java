package com.sham.studylauncher;
import android.content.*;
public final class BootReceiver extends BroadcastReceiver { @Override public void onReceive(Context c,Intent i){ AlarmScheduler.scheduleAll(c); } }
