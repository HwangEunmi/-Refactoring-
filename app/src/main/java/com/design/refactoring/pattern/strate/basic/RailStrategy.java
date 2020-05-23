package com.design.refactoring.pattern.strate.basic;

/**
 * 선로를 통해 이동하는 전략
 */
public class RailStrategy implements IMovableStrategy {
    @Override
    public void move() {
        System.out.println("선로를 통해 이동한다.");
    }
}
