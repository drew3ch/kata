import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws IllegalArgumentException {
        String[] data = input.split(" ");
        if (data.length != 3) {
            throw new IllegalArgumentException("Неверный формат. Введите два операнда и оператор разделенные пробелом.");
        }

        int num1 = Integer.parseInt(data[0]);
        int num2 = Integer.parseInt(data[2]);
        char operator = data[1].charAt(0);
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Нельзя делить на ноль.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор. Поддерживаемые операции: +, -, *, /.");
        }

        return Integer.toString(result);
    }
}