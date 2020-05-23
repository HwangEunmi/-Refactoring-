package com.design.refactoring.pattern.state.deepening;

/**
 * 행위 상태 인터페이스
 */
public interface IState {

    void insertMoney(int money); // 돈을 투입한다.

    void pushButton(int price); // 버튼을 누른다.

    void returnMoney(); // 거스름돈을 반환한다.

}
