package com.design.refactoring.pattern.state.deepening;

/**
 * 돈이 없는 상태
 */
public class NoMoneyState implements IState {

    private JuiceMachine machine;

    public NoMoneyState(JuiceMachine machine) {
        this.machine = machine;
    }

    // 돈을 투입한다.
    @Override
    public void insertMoney(int money) {
        machine.getMoneyBox().insert(money);
        System.out.println(money + "원을 넣었습니다.");

        if (money >= machine.getJuice().getPrice()) {
            // 돈이 전혀 투입되지 않은 상태에서 음료를 사기에 충분한 돈을 투입한 경우
            machine.setState(machine.getEnoughMoneyState()); // 돈이 충분한 상태로 변경한다.
        } else {
            // 음료를 사기에 충분한 돈이 투입되지 않은 경우
            machine.setState(machine.getNoEnoughMoneyState()); // 돈이 충분하지 않은 상태로 변경한다.
            System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원 입니다.");
        }
    }

    // 돈이 전혀 투입되지 않은 상태에서 버튼을 누르는 경우
    @Override
    public void pushButton(int price) {
        System.out.println("동전을 넣어주세요.");
    }

    // 돈이 전혀 투입되지 않은 상태에서 돈 반환을 요구하는 경우
    @Override
    public void returnMoney() {
        System.out.println("반환할 동전이 없습니다.");
    }

}
