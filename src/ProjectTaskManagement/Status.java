package ProjectTaskManagement;

public enum Status {
    TODO,
    IN_PROGRESS,
    REVIEW,
    DONE;


    public boolean canTransitionTo(Status status){
        return this.ordinal() + 1 == status.ordinal();
    }

}
