package com.design.refactoring.pattern.state.deepening;

/**
 * 음료 재고가 없는 상태
 */
public class SoldOutState implements IState{

    private JuiceMachine machine;

    public SoldOutState(JuiceMachine machine) {
        this.machine = machine;
    }

    // 재고가 없는 상태에서 돈이 투입되면 재고가 없다는 메시지를 출력한다.
    @Override
    public void insertMoney(int money) {
        System.out.println("재고가 없습니다.");
    }

    // 재고가 없는 상태에서는 구입 버튼을 눌러도 동작하지 않는다.
    @Override
    public void pushButton(int price) {

    }

    // 재고가 없는 상태에서 투입된 돈을 반환한다.
    @Override
    public void returnMoney() {
        int temp = machine.getMoneyBox().returnMoney();
        System.out.println(temp + "원이 반환되었습니다.");
        machine.setState(machine.getNoMoneyState()); // 돈이 없는 상태로 변경한다.
    }

}
