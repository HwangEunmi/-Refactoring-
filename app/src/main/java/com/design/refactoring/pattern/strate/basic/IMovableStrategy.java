package com.design.refactoring.pattern.strate.basic;

/**
 * 운송수단 전략에 따라 동작이 바뀌는 인터페이스
 */
public interface IMovableStrategy {
    void move(); // 움직인다.
}
