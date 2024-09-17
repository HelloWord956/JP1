import java.util.Scanner;

public class Main {
    public static void Show(int amount, double interest, String currency, double totalMoney, int month) {
        System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-10s |\n", "X", "Kỳ hạn", "Loại tiền gửi", "Tiền lãi theo kỳ", "Lãi + Gốc");
        System.out.printf("| %-15d | %-10d | %-13s | %-15.2f | %-10.2f |\n", amount, month, currency, interest, totalMoney);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount; // Số lượng tiền mà người dùng gửi
        double interest; // Số tiền lãi
        double totalMoney; // tổng số tiền
        int month;
        String currency = "VND"; //Đơn vị tiền tệ

        System.out.println("Nhập vào số tiền bạn gửi:");
        amount = sc.nextInt();
        System.out.println("Nhập vào số tháng bạn muốn gửi:");
        month = sc.nextInt();

        switch (month) {
            case 6:
                interest = amount * 5.1 / 100;
                totalMoney = amount + interest;
                Show(amount, interest, currency, totalMoney, month);
                break;
            case 9:
                interest = amount * 5.5 / 100;
                totalMoney = amount + interest;
                Show(amount, interest, currency, totalMoney, month);
                break;
            case 12:
                interest = amount * 6.4 / 100;
                totalMoney = amount + interest;
                Show(amount, interest, currency, totalMoney, month);
                break;
            case 24, 36:
                interest = amount * 6.5 / 100;
                totalMoney = amount + interest;
                Show(amount, interest, currency, totalMoney, month);
                break;
            default:
                System.out.println("Ngân hàng không hỗ trợ định kỳ mà bạn đã yêu cầu.");
                break;
        }
        sc.close();
    }
}