package com.design.refactoring.pattern.state.deepening;

/**
 * 자판기가 가진 돈에 대한 클래스
 */
public class MoneyBox {

    private int money = 0;

    public int getMoney() {
        return money;
    }

    // 돈을 price 만큼 넣는다.
    public void insert(int price) {
        this.money += price;
    }

    // 음료를 선택할때마다 돈이 줄어든다.
    public void dispense(int price) {
        this.money -= price;
    }

    // 돈을 반환한다.
    public int returnMoney() {
        int temp = this.money;
        this.money = 0;
        return temp;
    }

}
