package com.design.refactoring.pattern.strate.basic;

/**
 * 운송수단 전략을 셋팅하는 클래스
 */
public class Moving {
    private IMovableStrategy strategy;

    protected void setMovableStrategy(final IMovableStrategy strategy) {
        this.strategy = strategy;
    }

    protected void move() {
        strategy.move();
    }
}
