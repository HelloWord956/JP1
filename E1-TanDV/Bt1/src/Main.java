import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMoney = 0;
        int amount = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Nhập số tiền cần rút (VND): ");
            try {
                amount = scanner.nextInt();
                totalMoney = amount;

                // Kiểm tra số tiền có phải là bội số của 50.000 không
                if (amount % 50000 == 0) {
                    validInput = true;
                } else {
                    System.out.println("Số tiền cần rút phải là bội số của 50.000 VND. Vui lòng nhập lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
                scanner.next(); // Xóa bỏ đầu vào không hợp lệ
            }
        }

        int num500k = 0, num200k = 0, num100k = 0, num50k = 0;

        if (amount >= 500000) {
            num500k = amount / 500000;
            amount = amount % 500000;
        }
        if (amount >= 200000) {
            num200k = amount / 200000;
            amount = amount % 200000;
        }
        if (amount >= 100000) {
            num100k = amount / 100000;
            amount = amount % 100000;
        }
        if (amount >= 50000) {
            num50k = amount / 50000;
            amount = amount % 50000;
        }

        // Tổng số tờ tiền
        int totalNotes = num500k + num200k + num100k + num50k;

        // Hiển thị kết quả với căn chỉnh
        System.out.printf("| %-10s | %-6s | %-6s | %-6s | %-5s | %-10s |%n", "X", "Tờ 500", "Tờ 200", "Tờ 100", "Tờ 50", "Tổng số tờ");
        System.out.printf("| %-10d | %-6d | %-6d | %-6d | %-5d | %-10d |%n", totalMoney, num500k, num200k, num100k, num50k, totalNotes);
        
        scanner.close();
    }
}

