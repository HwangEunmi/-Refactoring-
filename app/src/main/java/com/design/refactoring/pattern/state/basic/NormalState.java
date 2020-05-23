package com.design.refactoring.pattern.state.basic;

/**
 * 보통 상태의 클래스
 */
public class NormalState implements IState {
    private static IState instance = new NormalState(); // 싱글톤 패턴으로 인스턴스 한번만 생성

    public static IState getInstance() {
        return instance;
    }

    @Override
    public void normal(final Clock clock) {
        System.out.println("NormalState's normal() 호출");
    }

    @Override
    public void alarm(final Clock clock) {
        System.out.println("NormalState's alarm() 호출");
        clock.setState(AlarmState.getInstance());
    }
}
