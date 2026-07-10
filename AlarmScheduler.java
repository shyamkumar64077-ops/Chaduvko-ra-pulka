package com.sham.studylauncher;
import android.app.*; import android.content.*; import java.util.*;
final class AlarmScheduler {
 static void schedule(Context c, Lesson l, int request) {
  Calendar when=Calendar.getInstance(); when.set(Calendar.DAY_OF_WEEK,l.day); when.set(Calendar.HOUR_OF_DAY,l.hour); when.set(Calendar.MINUTE,l.minute); when.set(Calendar.SECOND,0); when.set(Calendar.MILLISECOND,0);
  if (when.getTimeInMillis()<=System.currentTimeMillis()) when.add(Calendar.DATE,7);
  Intent i=new Intent(c,AlarmReceiver.class).putExtra("lesson",request);
  PendingIntent pi=PendingIntent.getBroadcast(c,request,i,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
  AlarmManager am=c.getSystemService(AlarmManager.class);
  am.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,when.getTimeInMillis(),pi);
 }
 static void scheduleAll(Context c){for(int i=0;i<Schedule.ALL.length;i++) schedule(c,Schedule.ALL[i],i);}
}
