import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Пусть дан произвольный список целых чисел, удалить из него четные числа.
 */
public class task1
{
    public static void main(String[] args)
    {
        List<Integer> list = CreateRandomList(1, 20, 10);
        System.out.printf("Задан список целых чисел: %s\n", list);
        DelEvenNumsFromList(list);
        System.out.printf("После удаления четных чисел получили список: %s\n", list);
    }

    // Создать список размером size, заполненный случайными числами в диапазоне от min до max.
    private static List<Integer> CreateRandomList(int min, int max, int size)
    {
        var randArrayList = new ArrayList<Integer>(size);
        var rand = new Random();
        for(int i = 0; i < size; i++)
            randArrayList.add(rand.nextInt(min,max));
        return randArrayList;
    }

    // Удалить четные числа из списка list.
    private static void DelEvenNumsFromList(List<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i) % 2 == 0)
                list.remove(i--);
        }
    }
}