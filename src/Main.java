import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String s = "\\d+\\s[+,\\-, *, %, /, ^]\\s\\d+";
        double result = 0;
        String inputString;
        try (BufferedReader br = new BufferedReader(new FileReader("src//input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src//output.txt"))) {

            while ((inputString = br.readLine()) != null) {
                //System.out.println(inputString);
                if ((inputString.trim().matches(s))) {
                    result = split(inputString.split(" "), result);
                    bw.write(result + "\n");
                    System.out.println(result);
                } else {
                    bw.write("Введены некорректные данные" + "\n");
                    System.out.println("Ввод не корректен!");
                }
            }
        }
    }
    private static double split(String[] array, double previousResult) throws Exception {
        String operand;
        double number1;
        double number2;
        if (array.length == 3) {
            number1 = Double.parseDouble(array[0]);
            operand = array[1];
            number2 = Double.parseDouble(array[2]);
            return calculate(number1, number2, operand);
        } else {
            throw new Exception("Ввод не корректен");
        }
    }
    private static double calculate(double number1, double number2, String operand) throws Exception {
        switch (operand) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            case "^":
                return Math.pow(number1, number2);
            case "%":
                return number1 % number2;
            default:
                throw new Exception("Ввод не корректен");
        }
    }
}