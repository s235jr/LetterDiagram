import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        String filepath = "C:\\git\\lettersdiagram\\76.txt";
        int[] arrayOfLetters;
        arrayOfLetters = generateArrayOfLetters(filepath);
        printArray(arrayOfLetters);

    }

    static int[] generateArrayOfLetters(String filepath) {
        int[] arrayOfLetters = new int['z' - 'a' + 1];
        BufferedReader filereader = null;
        try {
            filereader = new BufferedReader(new FileReader(filepath));
            String read;
            while ((read = filereader.readLine()) != null) {
                for (int i = 0; i < read.length(); i++) {
                    int indexOfChar = read.charAt(i);
                    if (indexOfChar >= 'a' && indexOfChar <= 'z') {
                        indexOfChar = read.charAt(i) - 'a';
                        arrayOfLetters[indexOfChar] = arrayOfLetters[indexOfChar] + 1;
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Nie udało się otworzyć pliku.");
        }
        return arrayOfLetters;
    }

    static int findMaxValue(int[] array) {
        int maxValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    static void printArray(int[] array) {
        int maxValue = findMaxValue(array);
        int scope = 50;
        int scale = maxValue / scope;
        String sign = "";

        for (int i = 0; i < scope; i++) {
            sign = sign + "#";
        }

        for (int i = 0; i < array.length; i++) {
            int k = array[i] / scale;
            String addSpace = "";
            if (array[i] < 10000) {
                addSpace = addSpace + " ";
            }
            if (array[i] < 1000) {
                addSpace = addSpace + " ";
            }
            if (array[i] < 100) {
                addSpace = addSpace + " ";
            }
            if (array[i] < 10) {
                addSpace = addSpace + " ";
            }
            System.out.println("Litera " + (char) (i + 97) + " występuje w tekście " + array[i] + " razy. " + addSpace + sign.substring(scope - k));
        }
    }
}