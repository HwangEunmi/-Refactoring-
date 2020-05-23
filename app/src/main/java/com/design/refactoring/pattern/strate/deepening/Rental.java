package com.design.refactoring.pattern.strate.deepening;

/**
 * 빌리는 행위 클래스
 */
public class Rental {

    private Member member; // 회원
    private Book book; // 책
    private IPricePolicy iPricePolicy; // 가격 정책
    int n; // 수량

    public Rental(Member member, Book book, IPricePolicy iPricePolicy, int n) {
        this.member = member;
        this.book = book;
        this.iPricePolicy = iPricePolicy; // 가격 정책을 대입
        this.n = n;
        this.member.addAccPrice(iPricePolicy.calcPrice(book.getPrice(), n)); // 정책대로 책 가격을 계산해서 회원에게 셋팅한다. (초기값)
    }

    public int getPrice() {
        return iPricePolicy.calcPrice(book.getPrice(), n); // 정책대로 책 가격을 계산한다.
    }

}
