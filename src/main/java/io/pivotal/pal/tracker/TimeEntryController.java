package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.PrimitiveIterator;

@RestController
public class TimeEntryController {

    private final  TimeEntryRepository timeEntryRepo;

    public TimeEntryController(TimeEntryRepository timeEntryRepo) {
        this.timeEntryRepo = timeEntryRepo;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timetoCreate){
        TimeEntry created=this.timeEntryRepo.create(timetoCreate);
        ResponseEntity<TimeEntry> result=new ResponseEntity<TimeEntry>(created, HttpStatus.CREATED);
        return  result;
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeToUpdate ){
        TimeEntry updated=this.timeEntryRepo.update(timeEntryId,timeToUpdate);
        if(updated != null) {
            return new ResponseEntity < TimeEntry > (updated,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId ){
        TimeEntry read=this.timeEntryRepo.find(timeEntryId);
        if(read != null) {
            return new ResponseEntity < TimeEntry > (read,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId ){
        this.timeEntryRepo.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> list=this.timeEntryRepo.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
