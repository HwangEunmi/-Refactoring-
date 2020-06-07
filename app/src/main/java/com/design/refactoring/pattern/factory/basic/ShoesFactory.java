package com.design.refactoring.pattern.factory.basic;

/**
 * 신발을 만들어내는 팩토리 클래스
 */
public class ShoesFactory extends ShoesStore {

    @Override
    public Shoes makeShoes(String type) {
        switch (type) {
            case "BLACK":
                return new BlackShoes();
            case "RED":
                return new RedShoes();
            default:
                return null;
        }
    }

}
