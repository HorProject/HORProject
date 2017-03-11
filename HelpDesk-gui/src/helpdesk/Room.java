package helpdesk;

import helpdesk.problem.Problem;
public class Room {
    private static String hName;
    private String room;
    private Problem[] problem;

    public Room(String room, String hName) {
        this.room = room;
        Room.hName = hName;
    }
    
    public int getFloor(){
        int floor = Integer.parseInt(room.substring(0,2));
        return floor;
    }

    public int getRoom() {
        return Integer.parseInt(room);
    }
    
    public int getNowP(int count){
        return problem[count].getNowP();
    }
    public int getYearP(int count){
        return problem[count].getYearP();
    }
    public int getLastYearP(int count) {
        return problem[count].getLastYearP();
    }
    public String getProblemStatus(int count){
        return problem[count].getProblemStatus();
    }
}
