package helpdesk.problem;

public class Problem {
    private String problem;

    public Problem(String problem) {
        this.problem = problem;
    }
    
    public int getLastYearP() {
        int lastYearP = Integer.parseInt(problem.substring(0, 2));
        return lastYearP;
    }
    public int getYearP() {
        int yearP = Integer.parseInt(problem.substring(2, 4));
        return yearP;
    }
    public int getNowP() {
        int nowP = Integer.parseInt(problem.substring(4, 5));
        return nowP;
    }
    public String getProblemStatus() {
        int problemState = Integer.parseInt(problem.substring(5, 6));
        String status = null;
        switch (problemState) {
            case 0 :
                status = "รอการดำเนินการ";
                break;
            case 1 :
                status = "กำลังดำเนินการ";
                break;
            case 2 :
                status = "เสร็จสิ้น";
                break;
        }
        return status;
    }
    public void setProblemStatus(int state) {
        problem = problem.substring(0, 5);
        problem += state;
    }
}
