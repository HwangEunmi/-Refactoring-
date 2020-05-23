package com.design.refactoring.pattern.state.deepening;

/**
 * 자판기
 */
public class JuiceMachine {

    private IState noMoneyState; // 돈이 하나도 없는 상태
    private IState noEnoughMoneyState; // 돈은 있으나 음료를 사기에 부족한 상태
    private IState enoughMoneyState; // 음료를 사기에 돈이 충분한 상태
    private IState soldOutState; // 음료가 매진된 상태
    private IState state;

    private MoneyBox moneyBox; // 자판기가 가진 돈에 대한 클래스
    private Juice juice; // 음료에 대한 클래스

    public JuiceMachine(int price, int stock) { // 가격, 재고
        noMoneyState = new NoMoneyState(this);
        noEnoughMoneyState = new NoEnoughMoneyState(this);
        enoughMoneyState = new EnoughMoneyState(this);
        soldOutState = new SoldOutState(this);

        moneyBox = new MoneyBox();
        juice = new Juice(price, stock);

        if (juice.getStock() > 0) {
            // 음료 재고가 있는 경우, 돈이 하나도 없는 상태가 자판기의 초기 상태다.
            state = noMoneyState;
        } else {
            // 음료 재고가 없는 경우, 자판기의 초기 상태는 매진 상태이다.
            state = soldOutState;
        }
    }

    // 현재 상태를 설정한다.
    public void setState(IState state) {
        this.state = state;
    }

    // 돈을 투입한다.
    public void insertMoney(int money) {
        state.insertMoney(money);
    }

    // (음료를 사기위해) 버튼을 누른다.
    public void pushButton() {
        int price = juice.getPrice();
        state.pushButton(price);
    }

    // 돈을 반환한다.
    public void returnMoney() {
        state.returnMoney();
    }

    // 자판기의 돈 클래스를 반환한다.
    public MoneyBox getMoneyBox() {
        return moneyBox;
    }

    // 음료 클래스를 반환한다.
    public Juice getJuice() {
        return juice;
    }

    public IState getNoMoneyState() {
        return noMoneyState;
    }

    public IState getNoEnoughMoneyState() {
        return noEnoughMoneyState;
    }

    public IState getEnoughMoneyState() {
        return enoughMoneyState;
    }

    public IState getSoldOutState() {
        return soldOutState;
    }

}
