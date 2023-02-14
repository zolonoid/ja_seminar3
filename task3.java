import java.util.Random;

/**
 * Реализовать алгоритм сортировки слиянием.
 */
public class task3
{
    public static void main(String[] args)
    {
        int[] arr = CreateRandomArray(1, 100, 10);
        System.out.printf("Задан массив целых чисел: %s\n", ArrayToString(arr));
        MergeSort(arr);
        System.out.printf("После выполнения сортировки слиянием получили массив: %s\n", ArrayToString(arr));
    }

    // Создать массив размером size, заполненный случайными числами в диапазоне от min до max.
    private static int[] CreateRandomArray(int min, int max, int size)
    {
        var randArray = new int[size];
        var rand = new Random();
        for (int i = 0; i < size; i++)
            randArray[i] = rand.nextInt(min, max);
        return randArray;
    }

    // Получить строковое представление массива arr.
    private static String ArrayToString(int[] arr)
    {
        var builder = new StringBuilder("[");
        for(int i = 0; i < arr.length; i++)
            builder.append(String.format("%d%s",arr[i],i < arr.length - 1 ? "," : ""));
        builder.append("]");
        return builder.toString();
    }
    
    // Сортировка слиянием.
    private static void MergeSort(int[] a)
    {
        int l = a.length;
        int blockSizeIterator;
        int blockIterator;
        int leftBlockIterator;
        int rightBlockIterator;
        int mergeIterator;
        int leftBorder;
        int midBorder;
        int rightBorder;

        for (blockSizeIterator = 1; blockSizeIterator < l; blockSizeIterator *= 2)
        {
            for (blockIterator = 0; blockIterator < l - blockSizeIterator; blockIterator += 2 * blockSizeIterator)
            {
                // Производим слияние с сортировкой пары блоков начинающуюся с элемента blockIterator.
                // Левый размером blockSizeIterator, правый размером blockSizeIterator или меньше.
                leftBlockIterator = 0;
                rightBlockIterator = 0;
                leftBorder = blockIterator;
                midBorder = blockIterator + blockSizeIterator;
                rightBorder = blockIterator + 2 * blockSizeIterator;
                rightBorder = (rightBorder < l) ? rightBorder : l;
                int[] sortedBlock = new int[rightBorder - leftBorder];

                // Пока в обоих массивах есть элементы выбираем меньший из них и заносим в отсортированный блок.
                while (leftBorder + leftBlockIterator < midBorder && midBorder + rightBlockIterator < rightBorder)
                {
                    if (a[leftBorder + leftBlockIterator] < a[midBorder + rightBlockIterator])
                    {
                        sortedBlock[leftBlockIterator + rightBlockIterator] = a[leftBorder + leftBlockIterator];
                        leftBlockIterator += 1;
                    }
                    else
                    {
                        sortedBlock[leftBlockIterator + rightBlockIterator] = a[midBorder + rightBlockIterator];
                        rightBlockIterator += 1;
                    }
                }
                // После этого заносим оставшиеся элементы из левого или правого блока.
                while (leftBorder + leftBlockIterator < midBorder)
                {
                    sortedBlock[leftBlockIterator + rightBlockIterator] = a[leftBorder + leftBlockIterator];
                    leftBlockIterator += 1;
                }
                while (midBorder + rightBlockIterator < rightBorder)
                {
                    sortedBlock[leftBlockIterator + rightBlockIterator] = a[midBorder + rightBlockIterator];
                    rightBlockIterator += 1;
                }
                for (mergeIterator = 0; mergeIterator < leftBlockIterator + rightBlockIterator; mergeIterator++)
                {
                    a[leftBorder + mergeIterator] = sortedBlock[mergeIterator];
                }
            }
        }
    }
}