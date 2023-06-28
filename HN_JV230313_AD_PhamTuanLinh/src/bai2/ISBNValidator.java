package bai2;

import java.util.Scanner;

public class ISBNValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập số có 10 chữ số:");
        String isbn = scanner.nextLine();
        if (isbn.length() != 10) {
            System.out.println("Số bạn nhập không phải ISBN");
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)){
                System.out.println("Số bạn nhập không phải ISBN");
                return;
            }
            int digit = Character.getNumericValue(c);
            sum += (i + 1) * digit;
        }
        if (sum % 11 == 0){
            System.out.println("Số bạn nhập là số ISBN");
        }else {
            System.out.println("Số bạn nhập không phải ISBN");
        }
    }
}
