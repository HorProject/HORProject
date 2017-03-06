package helpdesk;

import helpdesk.problem.ProblemName;
public class ShowListP implements ProblemName{
    private String room;
    private int status;
    private String hName;

    public ShowListP(String room, int status, String hName) {
        this.room = room;
        this.status = status;
        this.hName = hName;
    }
    
    public void showList() throws Exception {
        if (status == 1) {
            Room r = new Room(room, hName);
            for (int i = 0; i < 27; i++) {
                if(r.getNowP(i) > 0){
                    System.out.println(PROBLEMNAME[i]);
                }
            }
        }
        else {
        }
    }
}
