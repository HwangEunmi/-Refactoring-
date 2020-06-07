package com.design.refactoring.pattern.factory.basic;

/**
 * 신발 가게 클래스
 */
public abstract class ShoesStore {

    // 신발 주문하기
    public Shoes orderShoes(String type) {
        Shoes shoes = makeShoes(type);

        shoes.prepare(); // 신발을 준비한다.
        shoes.packing(); // 신발을 포장한다.

        return shoes;
    }

    public abstract Shoes makeShoes(String type);

}
