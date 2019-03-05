package hw_1;

import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * This is a simple program which does not needed any comments :)
 */
public class Converter {
    private static final double M_TO_MILES = 0.000621371;
    private static final double M_TO_YARDS = 1.09361;
    private static final double M_TO_FOOTS = 3.28084;
    private static final double KG_TO_POUND = 2.4419;
    private static final double KG_TO_UNCIA = 35.274;

    public static void main(String[] args) {
        double meter;
        double kg;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("This program can convert meters and kilograms...");
            System.out.println("Do you want to convert meters? 'Y'/'N'");
            String next = in.next();
            if (next.equalsIgnoreCase("Y")) {
                System.out.println("Enter meter...");
                if (in.hasNextDouble()) {
                    meter = in.nextDouble();
                    System.out.println("Want miles - press M");
                    System.out.println("Want yards - press Y");
                    System.out.println("Want foots - press F");
                    String letter = in.next();
                    if (letter.equalsIgnoreCase("M") ||
                            letter.equalsIgnoreCase("Y") ||
                            letter.equalsIgnoreCase("F")) {
                        printConvertedMeter(letter, meter);
                    } else
                        System.out.println("Wrong letter");

                } else {
                    System.out.println("Error! You should use numbers only");
                }
            } else if (next.equalsIgnoreCase("N")) {
                System.out.println("Do you want to convert kilograms? 'Y'/'N'");
                if (in.next().equalsIgnoreCase("Y")) {
                    System.out.println("Enter kilogram...");
                    if (in.hasNextDouble()) {
                        kg = in.nextDouble();
                        System.out.println("Want pound - press P");
                        System.out.println("Want uncia - press U");
                        String letter = in.next();
                        if (letter.equalsIgnoreCase("P") ||
                                letter.equalsIgnoreCase("U")) {
                            printConvertedKG(letter, kg);

                        } else
                            System.out.println("Wrong letter");
                    } else {
                        System.out.println("Error! You should use numbers only");
                        if (exitOrContinue(in).equalsIgnoreCase("E")) {
                            break;
                        }
                    }
                } else if (next.equalsIgnoreCase("N")) {
                    if (exitOrContinue(in).equalsIgnoreCase("E")) {
                        break;
                    }
                } else {
                    System.out.println("You should choose 'Y' or 'N'");
                }
            }
        }

    }

    private static double convertTo(double what, double to) {
        return what * to;
    }

    private static void printConvertedKG(String letter, double kg) {
        if (letter.equalsIgnoreCase("P")) {
            System.out.println("=============================================");
            System.out.println(kg + " kilograms are equal " + convertTo(kg, KG_TO_POUND) + " pounds");
            System.out.println("=============================================");
        }
        if (letter.equalsIgnoreCase("U")) {
            System.out.println("=============================================");
            System.out.println(kg + " kilograms are equal " + convertTo(kg, KG_TO_UNCIA) + " uncia");
            System.out.println("=============================================");
        }
    }

    private static void printConvertedMeter(String letter, double meter) {
        if (letter.equalsIgnoreCase("M")) {
            System.out.println("=============================================");
            System.out.println(meter + " meters are equal " + convertTo(meter, M_TO_MILES) + " miles");
            System.out.println("=============================================");
        }
        if (letter.equalsIgnoreCase("Y")) {
            System.out.println("=============================================");
            System.out.println(meter + " meters are equal " + convertTo(meter, M_TO_YARDS) + " yards");
            System.out.println("=============================================");
        }
        if (letter.equalsIgnoreCase("F")) {
            System.out.println("=============================================");
            System.out.println(meter + " meters are equal " + convertTo(meter, M_TO_FOOTS) + " foots");
            System.out.println("=============================================");
        }
    }

    private static String exitOrContinue(Scanner in) {
        System.out.println("Want out? - Press 'E'");
        System.out.println("Continue? - Press whatever else");
        String next = in.next();
        if (next.equalsIgnoreCase("E")) {
            System.out.print("Bye");
            for (int i = 0; i < 3; i++) {
                try {
                    sleep(500);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        return next;
    }
}
