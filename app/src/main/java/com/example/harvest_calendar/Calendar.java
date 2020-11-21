package com.example.harvest_calendar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;


import java.time.DayOfWeek;
import java.util.Date;
import java.util.Locale;


public class Calendar extends AppCompatActivity {
    CompactCalendarView compactCalendar;
    Points pointCal = new Points();
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
    private SimpleDateFormat dateFormatDay = new SimpleDateFormat("yyyy MM dd", Locale.getDefault());
    Button garden, challenges1, challenges2;
    TextView month;
    WeeklyChallenge chall = new WeeklyChallenge();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

        actionBar.setTitle("Hi, userid");


        Date day = new Date();


        month = (TextView) findViewById(R.id.month);
        month.setText(dateFormatMonth.format(day));


        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(day);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);

        if ((dayOfWeek == 1) || (chall.getChallenge().equals(""))) {
            chall.setChallenge();
            Button text = (Button) findViewById(R.id.missionButton);
            text.setText(chall.getChallenge());
        }

        compactCalendar = (CompactCalendarView) findViewById(R.id.calendar);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        compactCalendar.setFirstDayOfWeek(1);

        final CompactCalendarView calendarView = (CompactCalendarView) findViewById(R.id.calendar);
        setLevel();
        calendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                compactCalendar.setCurrentSelectedDayBackgroundColor(Color.rgb(0, 102, 255));
                Date day = new Date();
                String curr = dateFormatDay.format(day);
                String clicked = dateFormatDay.format(dateClicked);
                boolean today = false;
                if (curr.equals(clicked)) {
                    today = true;
                }
                if (!dateClicked.after(day)) {
                    open(calendarView, dateClicked.getTime(), today);
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                compactCalendar.setCurrentSelectedDayBackgroundColor(Color.rgb(0, 102, 255));
                month.setText(dateFormatMonth.format(firstDayOfNewMonth));
            }

        });

        garden = (Button) findViewById(R.id.gardenButton);

        garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Garden.class);
                startActivity(intent);
            }
        });

        challenges1 = (Button) findViewById(R.id.challengeButton);

        challenges1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Challenges.class);
                startActivity(intent);
            }
        });

        challenges2 = (Button) findViewById(R.id.missionButton);

        challenges2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Challenges.class);
                startActivity(intent);
            }
        });

    }

    public void open(View view, final long time, final boolean today){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Did you cook today?");
        alertDialogBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Event ev1 = new Event(Color.rgb(255, 150, 123), time, "no");
                compactCalendar.addEvent(ev1);
                pointCal.addEvent(ev1, compactCalendar);
                compactCalendar.setCurrentSelectedDayBackgroundColor(Color.rgb(255, 150, 123));
                if (today) {
                    compactCalendar.setCurrentDayBackgroundColor(Color.rgb(255, 150, 123));
                }
                setLevel();
            }
        });
        alertDialogBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Event ev1 = new Event(Color.rgb(0, 188, 171), time, "yes");
                compactCalendar.addEvent(ev1);
                pointCal.addEvent(ev1, compactCalendar);
                compactCalendar.setCurrentSelectedDayBackgroundColor(Color.rgb(0, 188, 171));
                if (today) {
                    compactCalendar.setCurrentDayBackgroundColor(Color.rgb(0, 188, 171));
                }
                setLevel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void setLevel() {
        pointCal.calculatePoints();
        Button text = (Button) findViewById(R.id.pointsButton);
        text.setText("Level: " + pointCal.getLevel() + "\n"
                + "Points: " + pointCal.getPoints() + "\n"
                + "Longest Streak: " + pointCal.getStreak());
    }
}
