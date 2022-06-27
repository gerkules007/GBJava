package lib.AlgorithmsCollection;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        }
        // разделяй и властвуй!
        int middle = array.size() / 2;
        List<Integer> left = array.subList(0, middle);
        List<Integer> right = array.subList(middle, array.size());
        // делим так до базового случая, и как говориться в самом названии - производим слияние
        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Integer> merge (List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int indexLeft = 0;
        int indexRight = 0;

        // пока не пройдем меньший из массивов, отсортируем числа по возрастанию
        while (indexLeft < left.size() && indexRight < right.size()) {
            if (left.get(indexLeft) < right.get(indexRight)) {
                result.add(left.get(indexLeft));
                indexLeft++;
            } else {
                result.add(right.get(indexRight));
                indexRight++;
            }
        }
        // склеим оставшиеся числа в большем листе
        result.addAll(left.subList(indexLeft, left.size()));
        result.addAll(right.subList(indexRight, right.size()));
        return result;
    }
}
