package com.design.refactoring.pattern.strate.basic;

/**
 * 도로를 통해 이동하는 전략
 */
public class LoadStrategy implements IMovableStrategy {
    @Override
    public void move() {
        System.out.println("도로를 통해 이동한다.");
    }
}
