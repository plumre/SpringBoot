package com.bayee.util.toBinary;

/*
 * Created by renhongjiang on 2019/2/28.
 */

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/28 14:14
 */
public class Integer2Binary {

    private static String toBinary(int i, StringBuilder sb) {
        if (i < 2) {
            return sb.append(i).toString();
        }
        // 取余
        int remainder = i % 2;
        // 取商
        i /= 2;
        // 递归
        toBinary(i, sb);
        return sb.append(remainder).toString();
    }

    private static int toDecimal(String binary) {
        int len = binary.length();
        String[] split = binary.split("");
        int decimal = 0;
        for (String s : split) {
            int anInt = Integer.parseInt(s);
            if (anInt == 0) {
                len--;
                continue;
            }
            decimal += anInt * Math.pow(2, --len);
        }
        return decimal;
    }

    private static int fibonacci(int n) {
        /*
        1、1、2、3、5、8、13、21、34 ，求第30位数是多少？
        */
        if (n < 3) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        String binary = "11001010";
        /*
          测试toBinary方法
         */
        String s = toBinary(192, new StringBuilder());
        System.out.println("\n" + s);
        /*
          测试toDecimal方法
         */
        int decimal = toDecimal(binary);
        System.out.println("decimal = " + decimal);

        /*
          测试Fibonacci方法
         */
        int fibonacci = fibonacci(30);
        System.out.println("fibonacci = " + fibonacci);
    }

}