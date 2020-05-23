package com.design.refactoring.pattern.state.basic;

/**
 * 시계 상태를 정의하는 인터페이스
 */
public interface IState {
    void normal(final Clock clock); // 보통 상태에 행할 행위
    void alarm(final Clock clock); // 알람이 울릴는 상태에 행할 행위
}
