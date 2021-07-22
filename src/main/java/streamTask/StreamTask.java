package streamTask;

import java.util.OptionalDouble;

import static java.util.Arrays.stream;

public class StreamTask {
    public static void main(String[] args) {
        int[] data = {5, 2, 3, 6, 0, 8, -7, 4, 9, 2, 3, 0};

        System.out.println(averageValueOfElements(data));
        System.out.println(getCountOfElementsEqualZero(data));
        System.out.println(getCountOfElementsThatMoreThanZero(data));
        getNumbersMultipliedOnAnotherNumber(data);
    }

    public static OptionalDouble averageValueOfElements(int[] data) {

        return stream(data).mapToDouble(value -> value).average();
    }

    public static long getCountOfElementsEqualZero(int[] data) {

        return stream(data).filter(el -> el == 0).count();
    }

    public static long getCountOfElementsThatMoreThanZero(int[] data) {

        return stream(data).filter(el -> el > 0).count();
    }

    public static void getNumbersMultipliedOnAnotherNumber(int[] data) {
        stream(data).map(el -> el * 2).forEach((x) -> System.out.print(x + " "));
    }
}
