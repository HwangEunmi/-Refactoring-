package com.design.refactoring.pattern.strate.deepening;

/**
 * 회원 가격 할인 정책
 */
public class MemberDiscountPricePolicy implements IPricePolicy{

    @Override
    public int calcPrice(int price, int n) {
        return (int) (price * n * 0.9);
    }

}
