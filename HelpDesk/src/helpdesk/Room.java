package helpdesk;

import helpdesk.problem.Problem;
public class Room {
    private String room;
    private Problem[] problem;

    public Room(String room, Problem[] problem) {
        this.room = room;
        this.problem = problem;
    }
    
    public int getFloor(){
        int floor = Integer.parseInt(room.substring(0,1));
        return floor;
    }

    public int getRoom() {
        return Integer.parseInt(room);
    }
}
