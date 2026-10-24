package ProjectTaskManagement;

import java.time.LocalDateTime;

public class ActivityLog {
    private LocalDateTime timestamp;
    private String message;

    public ActivityLog(String message){
        this.timestamp=LocalDateTime.now();
        this.message=message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getTimestamp()+"="+getMessage();
    }
}
