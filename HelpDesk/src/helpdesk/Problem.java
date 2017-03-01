package helpdesk;

public class Problem {
    String problem;

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
    public int getProblemState() {
        int problemState = Integer.parseInt(problem.substring(5, 6));
        return problemState;
    }
    public void setProblemState(int state) {
        problem = problem.substring(0, 5);
        problem += state;
    }
}
