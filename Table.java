package hw_2;

import java.util.HashSet;
import java.util.Set;

// Works stable with any numbers in range 2-9, if SIZE == 10 -> just increase stack :)
// -Xss1024M

public class Table {
    private static long START = System.currentTimeMillis();
    private final static byte SIZE = 10;
    private static int counter = 1;

    public static void main(String[] args) {
        startProcess(SIZE);
    }

    private static void startProcess(byte size) {
        byte[][] table = createTable(size);
        checkTable(table);
    }

    /**
     * Create square matrix
     *
     * @param size int
     * @return byte[][]
     */
    private static byte[][] createTable(byte size) {
        byte[][] table = new byte[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                table[i][j] = randomValue();
            }
        }
        return table;
    }

    /**
     * Generate byte value in range from 0 to 10 excluding
     *
     * @return byte
     */
    private static byte randomValue() {
        return (byte) (Math.random() * 10);
    }

    /**
     * Checks whether addNumber() worked to the end or not
     *
     * @param table which filled with random values by method createTable()
     */
    private static void checkTable(byte[][] table) {
        printTable(table);
        System.out.println("***"+ counter +"***");
        int i = addNumbers(table);
        if (i == -1) {
            counter++;
            startProcess(SIZE);
        } else {
            printTable(table);
            System.out.println("Program worked = " + (System.currentTimeMillis() - START) + " millis");
            System.exit(0);//trying to escape from stackOverFlow...
        }
    }

    /**
     * Print matrix
     */
    private static void printTable(byte[][] table) {
        System.out.println();
        for (byte[] aTable : table) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(aTable[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @param table which filled with random values by method createTable()
     * @return -1 -> start process again
     */
    private static int addNumbers(byte[][] table) {
        Set<Byte> set = new HashSet<>();
        for (int i = 1; i < table.length; i++) {
            set.add(table[0][0]);
            while (set.contains(table[0][i])) {
                table[0][i] = randomValue();
            }
            set.add(table[0][i]);
        }
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                Set<Byte> set1 = new HashSet<>();
                for (int k = 0; k < i; k++) {
                    set1.add(table[k][j]);
                }
                for (int k = 0; k < i; k++) {
                    Set<Byte> tempSet = new HashSet<>();
                    while (set1.contains(table[i][j])) {
                        table[i][j] = randomValue();
                        tempSet.add(table[i][j]);
                        if (tempSet.size() == 10) {
                            return -1;
                        }
                    }
                }
                for (int k = 0; k < j; k++) {
                    set1.add(table[i][k]);
                }
                for (int l = 0; l < j; l++) {
                    Set<Byte> tempSet = new HashSet<>();
                    while (set1.contains(table[i][j])) {
                        table[i][j] = randomValue();
                        tempSet.add(table[i][j]);
                        if (tempSet.size() == 10) {
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
