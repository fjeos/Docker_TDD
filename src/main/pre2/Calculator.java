package com.example.tdddemo;

public class Calculator {
    public int add(int a, int b) {
        if (willAdditionOverflow(a, b)) {
            if (a > 0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return a + b;
    }

    private boolean willAdditionOverflow(int a, int b) {
        if (b > 0 && a > Integer.MAX_VALUE - b) {
            return true;
        }
        if (b < 0 && a < Integer.MIN_VALUE - b) {
            return true;
        }
        return false;
    }
    /**
     * 두 정수의 차를 계산합니다.
     *
     * @param a 빼기를 당하는 수
     * @param b 빼는 수
     * @return 두 정수의 차
     * @throws ArithmeticException 결과가 int 범위를 초과할 경우
     */
    public int sub(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public int mul(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public int div(int a, int b) {
        return Math.floorDiv(a, b);
    }


}
