package com.design.refactoring.pattern.strate.deepening;

/**
 * 가격 정책 인터페이스
 */
public interface IPricePolicy {
    int calcPrice(int price, int n); // 정책대로 가격을 계산한다. (가격, 수량)
}
