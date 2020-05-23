package com.design.refactoring.pattern.strate.deepening;

/**
 * 책 자체가격 할인 정책
 */
public class BookDiscountPricePolicy implements IPricePolicy{

    @Override
    public int calcPrice(int price, int n) {
        return (int) (price * n * 0.95);
    }

}
