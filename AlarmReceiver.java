package com.sham.studylauncher;
import android.content.*; import android.net.Uri;
public final class AlarmReceiver extends BroadcastReceiver {
 @Override public void onReceive(Context c, Intent intent) {
  int id=intent.getIntExtra("lesson",-1); if(id<0||id>=Schedule.ALL.length)return; Lesson l=Schedule.ALL[id];
  Intent open=new Intent(Intent.ACTION_VIEW, Uri.parse(l.url)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
  open.setPackage("com.google.android.youtube");
  if(open.resolveActivity(c.getPackageManager())==null) open.setPackage(null);
  try { c.startActivity(open); } catch(Exception ignored) { }
  AlarmScheduler.schedule(c,l,id);
 }
}
