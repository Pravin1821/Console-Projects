package service;

import model.Analytics;
import model.Habit;
import model.HabitLog;
import model.Rewards;

import java.util.ArrayList;
import java.util.HashMap;

public class HabitService {
    UserService userService = new UserService();
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
        int streak = getCurrentStreak(history);
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
        int points=0,completed=completed(log);
        for(HabitLog i:log)
        {
            if(i.isCompleted())
            {
                points+=10;
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
        int total = log.size();
        double completionRate = (completed(log)*100.0)/total;
        analytics.setCompletionRate(completionRate);
        analytics.setCurrentStreak(getCurrentStreak(log));
        analytics.setLongestStreak(getLongestStreak(log));
        int count = 0;
        java.time.LocalDate today = java.time.LocalDate.now();
        for(HabitLog i : log)
        {
            java.time.LocalDate logDate = i.getDateTime().toLocalDate();

            if(!logDate.isBefore(today.minusDays(6))) // last 7 days
            {
                if(i.isCompleted())
                    count++;
            }
        }
        double consistencyScore = (count * 100.0) / 7;
        analytics.setConsistencyScore(consistencyScore);
        System.out.println(analytics);
    }
    public int completed(ArrayList<HabitLog> logs)
    {
        int com=0;
        for(HabitLog i:logs)
        {
            if(i.isCompleted())
                com++;
        }
        return com;
    }
    public int getCurrentStreak(ArrayList<HabitLog> logs)
    {
        ArrayList<HabitLog> sortedLogs = new ArrayList<>(logs);
        sortedLogs.sort((x,y) -> y.getDateTime().compareTo(x.getDateTime()));
        int currentStreak = 0;
        java.time.LocalDate checkDate = java.time.LocalDate.now();
        for(HabitLog log : sortedLogs)
        {
            java.time.LocalDate logDate = log.getDateTime().toLocalDate();
            if(logDate.equals(checkDate) && log.isCompleted())
            {
                currentStreak++;
                checkDate = checkDate.minusDays(1);
            }
            else if(logDate.isBefore(checkDate))
            {
                break;
            }
        }
        return currentStreak;
    }
    public int getLongestStreak(ArrayList<HabitLog> logs)
    {
        ArrayList<HabitLog> sortedLogs = new ArrayList<>(logs);
        sortedLogs.sort((x,y) -> x.getDateTime().compareTo(y.getDateTime()));
        int temp=0,max=0;
        for(HabitLog i:sortedLogs)
        {
            if(i.isCompleted())
            {
                temp++;
                max=Math.max(temp,max);
            }
            else
                temp=0;
        }
        return max;
    }
}
