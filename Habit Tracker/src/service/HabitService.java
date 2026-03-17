package service;

import model.Analytics;
import model.Habit;
import model.HabitLog;
import model.Rewards;

import java.util.ArrayList;
import java.util.HashMap;

public class HabitService {
    HashMap<Integer, ArrayList<Habit>> habitMap = new HashMap<>();
    HashMap<Integer, ArrayList<HabitLog>> habitLogMap = new HashMap<>();
    public void createHabits(Habit habit)
    {
        habitMap.putIfAbsent(habit.getUserId(),new ArrayList<>());
        if(habitMap.get(habit.getUserId()).contains(habit))
        {
            System.out.println("Habit already exists");
            return;
        }
        habitMap.get(habit.getUserId()).add(habit);
        System.out.println("Habit added to Habit Tracker");
    }
    public void viewHabits(int userId)
    {
        ArrayList<Habit> habits = habitMap.get(userId);
        if(habits == null || habits.isEmpty())
        {
            System.out.println("No habits found");
            return;
        }
        for(Habit hb: habits)
            System.out.println(hb);
    }
    public void TrackHabit(int id,int habitId, boolean status)
    {
        HabitLog log = new HabitLog();
        log.setLogID();
        log.setHabitId(habitId);
        log.setDateTime();
        log.setCompleted(status);
        if(habitLogMap.containsKey(id))
        {
            habitLogMap.get(id).add(log);
        }
        else {
            habitLogMap.put(id,new ArrayList<>());
            habitLogMap.get(id).add(log);
        }
        updateStreak(id,habitId);
    }
    public void updateStreak(int id,int habitId)
    {
        ArrayList<HabitLog> log = habitLogMap.get(id);
        ArrayList<HabitLog> history = new ArrayList<>();
        for(HabitLog i:log)
        {
            if(i.getHabitId()==habitId)
                history.add(i);
        }
        if(history.isEmpty())
                return;
        history.sort((a, b) -> b.getDateTime().compareTo(a.getDateTime()));
        int streak = 0;
        java.time.LocalDate checkDate = java.time.LocalDate.now();
        for(HabitLog i:history)
        {
            java.time.LocalDate logDate = i.getDateTime().toLocalDate();
            if(logDate.equals(checkDate) && i.isCompleted())
                streak++;
            else
                break;
        }
        ArrayList<Habit> habits = habitMap.get(id);
        if(habits!=null)
        {
            for(Habit i:habits)
            {
                if(i.getHabitId()==habitId)
                {
                    i.setCurrentStreak(streak);
                }
            }
        }
    }
    public void getRewards(int id)
    {
        Rewards rewards = new Rewards(id);
        ArrayList<HabitLog> log = habitLogMap.get(id);
        if(log==null)
            return;
        int points=0,completed=0;
        for(HabitLog i:log)
        {
            if(i.isCompleted())
            {
                points+=10;
                completed++;
            }
        }
        rewards.setLevel(points/100);
        rewards.setPoint(points);
        if(completed>=50)
            rewards.setBadge("Legend");
        else if(completed>=15)
            rewards.setBadge("Master");
        else
            rewards.setBadge("Consistent");
        System.out.println(rewards);
    }
    public void TrackAnalytics(int id)
    {
        Analytics analytics = new Analytics(id);
        ArrayList<HabitLog> log = habitLogMap.get(id);
        if(log==null)
            return;

    }
}
