package com.design.refactoring.pattern.strate.deepening;

/**
 * 회원 클래스
 */
public class Member {

    // 회원은 이름과 누적 대여 금액을 가짐
    private String name; // 이름
    private int accPrice; // 누적 대여 금액

    public Member(String name) {
        this.name = name;
        this.accPrice = 0;
    }

    public String getName() {
        return name;
    }

    public void addAccPrice(int price) {
        this.accPrice += price;
    }

    public int getAccPrice() {
        return accPrice;
    }

}
