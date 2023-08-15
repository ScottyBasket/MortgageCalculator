import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {

        //Mortgage Calculator
        int principle = (int)readNumber("Principle: ", 1000,1000000);
        float interestRate = (float)readNumber("Annual Interest Rate: ",0, 4);
        byte years = (byte)readNumber("Period (Years): ", 1, 30);
        monthlyPaymentsPrint(interestRate, years,principle);




        //FizzBuzz
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter Number: ");
//        int number = Integer.parseInt(scanner.nextLine());
//        if((number%5 == 0) && (number%3==0))
//            System.out.println("FizzBuzz");
//        else if ( number%5==0)
//            System.out.println("Fizz");
//        else if (number%3 == 0)
//            System.out.println("Buzz");
//        else
//            System.out.println(number);
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            float interestRate,
            byte years,
            int principle
            ){
        float interest = (interestRate/100)/12;
        double mortgage = principle* ( ((interest)* Math.pow((1+interest),(years*12)))/(Math.pow((1+interest),(years*12)) - 1) );
        return mortgage;

    }

    public static void monthlyPaymentsPrint(
            float interestRate,
            byte years,
            int principle
    ){
        double c = (interestRate/100)/12;
        int n = years*12;
        int L = principle;

        int p = 0;
        double mortgage = calculateMortgage(interestRate, years, principle);
        System.out.println("\nMORTGAGE \n" +
                "--------\n" +
                "Monthly Payments: "+
                NumberFormat.getCurrencyInstance().format(mortgage) +
                "\n\nPayment Schedule \n" +
                "----------------");

        while (p <= n) {
            double finalBalance = (L * ((Math.pow((1 + c), n)) - Math.pow((1 + c), p))) / ((Math.pow((1 + c), n)) - 1);
            System.out.println("Month: " + p + " " +NumberFormat.getCurrencyInstance().format(finalBalance));
            p++;
        }
    }
}