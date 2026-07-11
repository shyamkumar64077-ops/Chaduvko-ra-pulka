package com.sham.studylauncher;
import android.app.*; import android.os.*; import android.provider.Settings; import android.content.*; import android.graphics.Color; import android.net.Uri; import android.view.*; import android.widget.*;
public final class MainActivity extends Activity {
 int pad(int n){return (int)(n*getResources().getDisplayMetrics().density);}
 @Override public void onCreate(Bundle b){super.onCreate(b); showHome();}
 @Override public void onResume(){super.onResume(); if(Build.VERSION.SDK_INT < 31 || ((AlarmManager)getSystemService(ALARM_SERVICE)).canScheduleExactAlarms()) AlarmScheduler.scheduleAll(this);}
 void showHome(){ LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(pad(24),pad(32),pad(24),pad(24));
  TextView title=t("Study Launcher",28); root.addView(title); root.addView(t("Android 16 · Opens YouTube automatically at your lesson times",16));
  Button enable=new Button(this); enable.setText("Enable automatic schedule"); enable.setOnClickListener(v->{ if(Build.VERSION.SDK_INT>=31 && !((AlarmManager)getSystemService(ALARM_SERVICE)).canScheduleExactAlarms()) requestAlarmAccess(); else {AlarmScheduler.scheduleAll(this); Toast.makeText(this,"Schedule enabled",Toast.LENGTH_LONG).show();}}); root.addView(enable);
  TextView route=t("Launch target: YouTube app  →  default browser if unavailable",15); route.setPadding(0,pad(12),0,pad(12)); root.addView(route);
  ScrollView sc=new ScrollView(this); LinearLayout list=new LinearLayout(this); list.setOrientation(LinearLayout.VERTICAL); for(Lesson l:Schedule.ALL) list.addView(t(day(l.day)+"  "+String.format("%02d:%02d",l.hour,l.minute)+"  ·  "+l.code,16)); sc.addView(list); root.addView(sc,new LinearLayout.LayoutParams(-1,0,1)); setContentView(root); }
 void requestAlarmAccess(){ Intent i=new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM, Uri.parse("package:"+getPackageName())); startActivity(i); }
 String day(int d){return new String[]{"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"}[d];}
 TextView t(String s,int size){TextView v=new TextView(this);v.setText(s);v.setTextSize(size);v.setTextColor(Color.DKGRAY);v.setPadding(0,pad(8),0,pad(8));return v;}
}
