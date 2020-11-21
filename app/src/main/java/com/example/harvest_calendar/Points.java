package com.example.harvest_calendar;

import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Points {
    int pointsTotal = 0;
    int level = 0;
    int streak = 0;
    ArrayList<Event> events = new ArrayList<Event>();
    int getPoints() {
        return pointsTotal;
    }
    int getLevel() {
        return level;
    }
    int getStreak() {return streak; }
    void addEvent(Event ev, CompactCalendarView cal) {
        for (int i = 0; i <= events.size(); i++) {
            if (i == events.size()) {
                events.add(ev);
                break;
            }

            if (events.get(i).getTimeInMillis() >= ev.getTimeInMillis()) {
                if (events.get(i).getTimeInMillis() == ev.getTimeInMillis()) {
                    cal.removeEvent(events.get(i));
                    events.remove(i);
                }
                events.add(i, ev);
                break;
            }
        }
    }

    private void calcStreak(int start) {
        int currStreak = 1;
        long currTime = events.get(start).getTimeInMillis();
        int curr = start - 1;
        String yes = "yes";
        if (curr >= 0) {
            while ((curr >= 0) && (events.get(curr).getTimeInMillis() == (currTime - 86400000L)) &&
                    events.get(curr).getData().equals(yes)) {
                currTime = events.get(curr).getTimeInMillis();
                curr -= 1;
                currStreak += 1;
            }
        }

        if (currStreak > streak) {
            streak = currStreak;
        }
    }

    void calculatePoints() {
        String no = "no";
        String yes = "yes";
        pointsTotal = 0;
        streak = 0;
        int size = events.size();
        for (int i = 0; i < size; i++) {
            if (events.get(i).getData().equals(yes)) {
                pointsTotal += 50;
            }
        }

        if (size > 0) {
        //    Date day = new Date();
       //     long currDay = day.getTime();
       //    Event currEvent = events.get(size - 1);

        //    long extra = currDay % 86400000L;
        //    currDay = currDay - extra;
        //    currDay += 18000000L;

            for (int i = size - 1; i >= 0; i--) {
                Event currEvent = events.get(i);
                if (currEvent.getData().equals(yes)) {
                    // (lastEvent.getTimeInMillis() == currDay)) {
                    calcStreak(i);
                }
            }
            pointsTotal += streak*10;
        }

        level = pointsTotal / 500;

    }
}
