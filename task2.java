import java.util.ArrayList;
import java.util.Random;

/**
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.
 */
public class task2
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrList = CreateRandomArrayList(10, 100, 5);
        System.out.printf("Задан список целых чисел: %s\n", arrList);
        int min = ArrayListMin(arrList);
        int max = ArrayListMax(arrList);
        double avrg = ArrayListAverage(arrList);
        System.out.printf("Минимум: %d\nМаксимум: %d\nСреднее: %f\n", min, max, avrg);
    }

    // Создать список размером size, заполненный случайными числами в диапазоне от min до max.
    private static ArrayList<Integer> CreateRandomArrayList(int min, int max, int size)
    {
        var randArrayList = new ArrayList<Integer>(size);
        var rand = new Random();
        for(int i = 0; i < size; i++)
            randArrayList.add(rand.nextInt(min,max));
        return randArrayList;
    }

    // Найти минимальное значение в списке arrList.
    private static int ArrayListMin(ArrayList<Integer> arrList)
    {
        int min = Integer.MAX_VALUE;
        for (int value : arrList)
        {
            if(value < min)
                min = value;
        }
        return min;
    }
    
    // Найти максимальное значение в списке arrList.
    private static int ArrayListMax(ArrayList<Integer> arrList)
    {
        int max = Integer.MIN_VALUE;
        for (int value : arrList)
        {
            if(value > max)
                max = value;
        }
        return max;
    }
    
    // Найти среднее арифметическое списка arrList.
    private static double ArrayListAverage(ArrayList<Integer> arrList)
    {
        double sum = 0;
        int size = arrList.size();
        for (int value : arrList)
            sum += value;
        return sum / size;
    }
}
