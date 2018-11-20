package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(long id);
    public TimeEntry update(Long id,TimeEntry timeEntry);
    public List<TimeEntry> list();
    public void delete(long id);

}
