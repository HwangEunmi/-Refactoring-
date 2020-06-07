package com.design.refactoring.pattern.factory.basic;

/**
 * 신발 클래스
 */
public abstract class Shoes {

    protected String name;

    public void prepare() {
        System.out.println("신발을 준비중입니다.");
    }

    public void packing() {
        System.out.println("신발을 포장하고 있습니다.");
    }

}
