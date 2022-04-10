package com.example.bsm.dto;


public class PersonalScoreForm {
    private String name;
    private Long score;
    private Long assist;
    private Long rebound;
    private Long steal;
    private Long block;
    private Long point2;
    private Long point3;
    private Long ft;
    private String play_date;

    public String getPlay_date() {
        return play_date;
    }

    public void setPlay_date(String play_date) {
        this.play_date = play_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getAssist() {
        return assist;
    }

    public void setAssist(Long assist) {
        this.assist = assist;
    }

    public Long getRebound() {
        return rebound;
    }

    public void setRebound(Long rebound) {
        this.rebound = rebound;
    }

    public Long getSteal() {
        return steal;
    }

    public void setSteal(Long steal) {
        this.steal = steal;
    }

    public Long getBlock() {
        return block;
    }

    public void setBlock(Long block) {
        this.block = block;
    }

    public Long getPoint2() {
        return point2;
    }

    public void setPoint2(Long point2) {
        this.point2 = point2;
    }

    public Long getPoint3() {
        return point3;
    }

    public void setPoint3(Long point3) {
        this.point3 = point3;
    }

    public Long getFt() {
        return ft;
    }

    public void setFt(Long ft) {
        this.ft = ft;
    }


}
