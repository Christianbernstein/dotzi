package de.christianbernstein.horizon.provider.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class ProviderThreadFactory implements ThreadFactory {

    private int counter;
    private String name;
    private List<String> stats;

    public ProviderThreadFactory(String name){
        counter = 1;
        this.name = name;
        stats = new ArrayList<String>();
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread: ID: %d, NAME: %s, TIME_STAMP %s \n", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats()
    {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while (it.hasNext())
        {
            buffer.append(it.next());
        }
        return buffer.toString();
    }
}
