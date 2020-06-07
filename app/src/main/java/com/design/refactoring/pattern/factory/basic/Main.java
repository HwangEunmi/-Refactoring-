package com.design.refactoring.pattern.factory.basic;

public class Main {

    public static void main(String[] args) {
        ShoesStore store = new ShoesFactory();

        Shoes shoes = store.orderShoes("BLACK"); // 검정색의 신발을 주문한다.
        System.out.println(shoes.name); // 검은 신발
    }

}
