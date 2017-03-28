package Model;

import java.sql.*;

public class Problem {
    private int causeId;
    private int problemP;
    private int problemC;
    private int problemN;
    private String name;
    private int problemId;
    private int statusId;
    private String status;
    private int roomNo;

    public Problem(int causeId, int roomNo) {
        this.causeId = causeId;
        this.roomNo = roomNo;
        try {
            Connection connect = ConnectionBuilder.getConnection();
            PreparedStatement ps = connect.prepareStatement(
                    "SELECT RecordProblem.problemPast, RecordProblem.problemCurrent, RecordProblem.problemNow, Problem.problemId, Problem.problemName, status.statusName, status.statusId "
                            + "FROM RecordProblem "
                            + "INNER JOIN Cause ON RecordProblem.Cause_causeId = Cause.causeId "
                            + "INNER JOIN Problem ON Cause.Problem_problemId = Problem.problemId "
                            + "INNER JOIN status ON Cause.status_statusId = status.statusId "
                            + "WHERE RecordProblem.Cause_causeId = ? ");
            ps.setInt(1,causeId);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                problemP = result.getInt("problemPast");
                problemC = result.getInt("problemCurrent");
                problemN = result.getInt("problemNow");
                problemId = result.getInt("problemId");
                name = result.getString("problemName");
                status = result.getString("statusName");
                statusId = result.getInt("statusId");
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
    public int getStatusId() {
        return statusId;
    }
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getRoom() {
        return roomNo;
    }
    public void setRoom(int roomNo) {
        this.roomNo = roomNo;
    }
}
