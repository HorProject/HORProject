package Model;

import java.sql.*;

public class Problem {
    private int causeId;
    private int problemP;
    private int problemC;
    private int problemN;
    private String name;
    private int problemId;
    private String status;
    private int room;

    public Problem(int causeId, int room) {
        this.causeId = causeId;
        this.room = room;
        try {
            Connection connect = new ConnectionBuilder().getConnection();
            PreparedStatement ps = connect.prepareStatement(
                    "SELECT recordproblem.problemPast, recordproblem.problemCurrent, recordproblem.problemNow, problem.problemId, problem.problemName, status.statusName "
                            + "FROM recordproblem "
                            + "INNER JOIN problem ON recordproblem.Cause_Problem_problemId = problem.problemId "
                            + "INNER JOIN status ON recordproblem.Cause_status_statusId = status.statusId "
                            + "WHERE recordproblem.Cause_causeId = ? ");
            ps.setInt(1,causeId);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                problemP = result.getInt("problemPast");
                problemC = result.getInt("problemCurrent");
                problemN = result.getInt("problemNow");
                name = result.getString("problemName");
                status = result.getString("statusName");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getCauseId() {
        return causeId;
    }
    public void setCauseId(int causeId) {
        this.causeId = causeId;
    }
    public int getProblemP() {
        return problemP;
    }
    public void setProblemP(int problemP) {
        this.problemP = problemP;
    }
    public int getProblemC() {
        return problemC;
    }
    public void setProblemC(int problemC) {
        this.problemC = problemC;
    }

    public int getProblemN() {
        return problemN;
    }
    public void setProblemN(int problemN) {
        this.problemN = problemN;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProblemId() {
        return problemId;
    }
    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }
}
