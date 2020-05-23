package com.design.refactoring.pattern.state.basic;

public class Clock {
    private IState state; // 상태를 저장한다.

    public Clock() {
        // 초기 상태를 지정한다.
        state = new NormalState();
    }

    public void setState(final IState state) {
        this.state = state;
    }

    public void normal() {
        state.normal(this);
    }

    public void alarm() {
        state.alarm(this);
    }
}
