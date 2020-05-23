package com.design.refactoring.pattern.state.basic;

/**
 * 알람 상태의 클래스
 */
public class AlarmState implements IState {

    private static final int MAX_COUNT = 5;
    private int count;

    private static IState instance = new AlarmState(); // 싱글톤 패턴으로 인스턴스 한번만 생성

    public static IState getInstance() {
        return instance;
    }


    @Override
    public void normal(final Clock clock) {
        System.out.println("AlarmState's normal() 호출");
        while (count < MAX_COUNT) {
            System.out.println(count);
            count++;
        }
        clock.setState(NormalState.getInstance());
    }

    @Override
    public void alarm(final Clock clock) {
        System.out.println("AlarmState's alarm() 호출");
    }
}
