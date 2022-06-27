package lib.AlgorithmsCollection;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        // собирается куча
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // элемент вытаскивается из кучи один за одним
        for (int i = n - 1; i >= 0; i--) {
            // каждый максимальный элемент, который был вытащили из кучи,
            // меняется со следующим i из массива
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // до каждого элемента выделяется самый максимальный
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        // по умолчанию максимальный элемент, который мы рассматриваем
        int max = i;
        // индексы ветвей дерева от числа
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        //если левое число есть в дереве и оно больше чем, родитель
        if (leftChild < n && arr[leftChild] > arr[max])
            max = leftChild;

        //если правое число есть в дереве и оно больше чем, родитель
        if (rightChild < n && arr[rightChild] > arr[max])
            max = rightChild;

        //меняем местами родителя и потомка местами, если потомок = максимальное
        if (max != i) {
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;

            //проверяем максимальное с другими родителями
            heapify(arr, n, max);
        }
    }
}
