package com.design.refactoring.pattern.state.deepening;

/**
 * 돈이 충분하지 않은 상태
 */
public class NoEnoughMoneyState implements IState{

    private JuiceMachine machine;

    public NoEnoughMoneyState(JuiceMachine machine) {
        this.machine = machine;
    }

    // 돈을 투입한다.
    @Override
    public void insertMoney(int money) {
        machine.getMoneyBox().insert(money);
        System.out.println(money + "원을 넣었습니다.");

        if(machine.getMoneyBox().getMoney() >= machine.getJuice().getPrice()) {
            // 돈이 충분하게 투입되지 않은 상태에서 음료를 사기에 충분한 돈을 투입한 경우
            machine.setState(machine.getEnoughMoneyState()); // 돈이 충분한 상태로 변경한다.
        } else {
            // 음료를 사기에 충분한 돈이 투입되지 않은 경우
            // machine.setState(machine.getNoEnoughMoneyState()); // 돈이 충분하지 않은 상태로 변경한다.
        }

        System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원 입니다.");
    }

    // 돈이 충분하게 투입되지 않은 상태에서 버튼을 누르는 경우
    @Override
    public void pushButton(int price) {
        System.out.println("동전이 부족합니다.");
    }

    // 돈이 충분하게 투입되지 않은 상태에서 돈 반환을 요구하는 경우, 돈을 반환한다.
    @Override
    public void returnMoney() {
        int temp = machine.getMoneyBox().returnMoney();
        System.out.println(temp + "원이 반환되었습니다.");
        machine.setState(machine.getNoMoneyState()); // 돈이 없는 상태로 변경한다.
    }

}
