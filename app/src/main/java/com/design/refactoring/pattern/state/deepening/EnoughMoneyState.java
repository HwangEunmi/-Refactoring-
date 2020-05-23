package com.design.refactoring.pattern.state.deepening;

/**
 * 돈이 충분한 상태
 */
public class EnoughMoneyState implements IState{

    private JuiceMachine machine;

    public EnoughMoneyState(JuiceMachine machine) {
        this.machine = machine;
    }

    // 돈을 투입한다.
    @Override
    public void insertMoney(int money) {
        machine.getMoneyBox().insert(money);
        System.out.println(money + "원을 넣었습니다.");
        System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원 입니다.");
    }

    @Override
    public void pushButton(int price) {
        machine.getMoneyBox().dispense(price);
        machine.getJuice().dispense(); // 음료를 구입한다.
        System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원 입니다.");

        if(machine.getJuice().getStock() == 0) {
            // 음료 재고가 없는 경우
            machine.setState(machine.getSoldOutState()); // 음료 재고가 없는 상태로 변경한다.
        } else if(machine.getMoneyBox().getMoney() < machine.getJuice().getPrice()) {
            // 잔액이 새 음료수를 구입하기에 충분하지 않은 경우
            machine.setState(machine.getNoEnoughMoneyState()); // 돈이 충분하지 않은 상태로 변경한다.
        } else if(machine.getMoneyBox().getMoney() == 0) {
            // 잔액이 하나도 없는 경우
            machine.setState(machine.getNoMoneyState()); // 돈이 없는 상태로 변경한다.
        }
    }

    // 잔액을 반환한 후 돈이 없는 상태로 변경한다.
    @Override
    public void returnMoney() {
        int temp = machine.getMoneyBox().returnMoney();
        System.out.println(temp + "원이 반환되었습니다.");
        machine.setState(machine.getNoMoneyState()); // 돈이 없는 상태로 변경한다.
    }

}
