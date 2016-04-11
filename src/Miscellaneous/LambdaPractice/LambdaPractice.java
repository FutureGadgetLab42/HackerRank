package Miscellaneous.LambdaPractice;


import java.util.Arrays;

public class LambdaPractice {
    public static void main(String[] args) {
        String str = "123";
        StringBuilder sb = new StringBuilder();
        Arrays.asList(str.toCharArray()).forEach(c -> System.out.println("" + c[0]));
//        System.out.println("" + sb);
    }
}
