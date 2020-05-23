package com.design.refactoring.pattern.strate.deepening;

/**
 * 메인 클래스 (Client 클래스)
 */
public class Client {

    public static void main(String[] args) {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        Book book1 = new Book("book1", 2005, 1000);
        Book book2 = new Book("book2", 2004, 1200);
        Book book3 = new Book("book3", 2001, 4300);

        Rental rental1 = new Rental(member1, book2, new OrdinaryPricePolicy(), 2); // 회원1이 책2를 일반적인 정책으로 두권 구입한다.
        Rental rental2 = new Rental(member2, book1, new OrdinaryPricePolicy(), 3); // 회원2가 책1을 일반적인 정책으로 세권 구입한다.
        Rental rental3 = new Rental(member2, book3, new BookDiscountPricePolicy(), 4); // 회원2가 책3을 책 자체가격 할인 정책으로 네권 구입한다.
        Rental rental4 = new Rental(member1, book2, new MemberDiscountPricePolicy(), 3); // 회원1이 책2를 회원 가격 할인 정책으로 세권 구입한다.

        System.out.println(rental1.getPrice()); // 2000
        System.out.println(rental2.getPrice()); // 3000
        System.out.println(rental3.getPrice()); // 16340
        System.out.println(rental4.getPrice()); // 3240

    }

}

// 사용 예1) 1. 회원은 이름과 누적 대여 금액을 갖는다.
//          2.  책은 서명, 출판년도, 가격을 갖는다 (재고는 무한대라고 가정)
//          3. 회원은 하나의 책을 1권 이상 살 수 있다.
//          4. 회원이 책을 살 때마다 누적 금액이 저장된다.
//          5. 가격 정책에 따라 책 값이 할인되며, 다른 가격 정책이 추가될 수 있다.
//          6. 10년 이상 된 책은 책 자체 할인, 누적 대여 금액이 만 원 이상이면 회원 할인, 그 외의 경우에는 할인이 없다.
//          => 이 경우 ① 10년 이상 되었을때의 할인 정책, ② 누적 대여 금액이 만원 이상일때의 할인 정책, ③ 할인이 없을때의 정책
//             세가지의 Strategy 클래스를 만들어 개발할 수 있다.
//          => 인터페이스 내부에 들어갈 메소드인 행위는 정책에 따른 가격 계산일 것이다.