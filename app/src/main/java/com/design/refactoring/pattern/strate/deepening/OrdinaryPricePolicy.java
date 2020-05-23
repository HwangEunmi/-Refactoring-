package com.design.refactoring.pattern.strate.deepening;

/**
 * 일반적인 가격 정책 (할인 X)
 */
public class OrdinaryPricePolicy implements IPricePolicy {

    @Override
    public int calcPrice(int price, int n) {
        return price * n;
    }

}
