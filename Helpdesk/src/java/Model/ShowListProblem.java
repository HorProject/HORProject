package Model;

import java.util.ArrayList;

public class ShowListProblem {
    private long userId;
    private int dormId;
    private ArrayList<Problem> list;

    public ShowListProblem() {
        list = new ArrayList<Problem>();
    }
    public ShowListProblem(long userId) {
        this();
        this.userId = userId;
    }
    public ShowListProblem(int dormId) {
        this();
        this.dormId = dormId;
    }
}
