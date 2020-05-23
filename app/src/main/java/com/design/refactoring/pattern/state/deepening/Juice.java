package com.design.refactoring.pattern.state.deepening;

/**
 * 음료에 대한 클래스
 */
public class Juice {

    private int price; // 가격
    private int stock; // 재고

    public Juice(int price, int stock) {
        this.price = price;
        this.stock = stock;
    }

    // 음료를 선택한다. (수량을 줄인다.)
    public void dispense() {
        this.stock--;
    }

    // 가격을 확인한다.
    public int getPrice() {
        return price;
    }

    // 재고를 확인한다.
    public int getStock() {
        return stock;
    }

}
