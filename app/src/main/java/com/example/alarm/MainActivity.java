package com.example.alarm;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TimePicker alarmT;
    TextClock currentT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmT = findViewById(R.id.timePicker);
        currentT = findViewById(R.id.textClock);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        Timer time = new Timer();

        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (currentT.getText().toString().equals(Alarm())) {
                    r.play();
                } else {
                    r.stop();
                }

            }
        }, 0, 1000);
    }

    public String Alarm() {

        Integer alarmHour = alarmT.getCurrentHour();
        Integer alarmMinute = alarmT.getCurrentMinute();
        String stringAlarmMinutes;

        if (alarmMinute < 10) {
            stringAlarmMinutes = "0";
            stringAlarmMinutes = stringAlarmMinutes.concat(alarmMinute.toString());

        } else {
            stringAlarmMinutes = alarmMinute.toString();
        }

        String stringAlarmTime;

        if (alarmHour > 12) {

            alarmHour = alarmHour - 12;
            stringAlarmTime = alarmHour.toString().concat(":").concat(alarmMinute.toString()).concat(" PM");

        } else {

            stringAlarmTime = alarmHour.toString().concat(":").concat(alarmMinute.toString()).concat(" AM");


        }
        return stringAlarmTime;

    }
}
