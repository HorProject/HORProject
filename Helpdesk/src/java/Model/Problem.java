package Model;

public class Problem {
    private int causeId;
    private String name;
    private String problemP;
    private String problemN;
    private String status;

    public Problem(int causeId) {
        this.causeId = causeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblemP() {
        return problemP;
    }

    public void setProblemP(String problemP) {
        this.problemP = problemP;
    }

    public String getProblemN() {
        return problemN;
    }

    public void setProblemN(String problemN) {
        this.problemN = problemN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
