package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long,TimeEntry> timeEntries=new HashMap<Long, TimeEntry>();
    int counter=0;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++counter);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
       TimeEntry existing=this.find(id);
       if(existing==null)
        return null;
       timeEntry.setId(id);
       timeEntries.put(id, timeEntry);
       return this.find(id);
    }


    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return Collections.list(Collections.enumeration(timeEntries.values()));
    }

    @Override
    public void delete(long id) {
        this.timeEntries.remove(id);
    }
}
