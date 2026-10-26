package ProjectTaskManagement;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoStack <T extends Undoable>{
    Deque<T> actions = new ArrayDeque<>();
    void push(T action){
        actions.addFirst(action);
        if(actions.size()>5){
            actions.removeLast();
        }
    }
    void undo(){
        if(actions.isEmpty()){
            System.out.println("Nothing to undo");
        }
        else {
            actions.removeFirst().undo();
        }
    }

}
