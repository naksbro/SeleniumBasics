package PracticeLang;

import java.util.*;

public class sortArr {
    public static void main(String[] args) {
        String[] strArr = {"1","7","10"};
        int[] numArr = {2, 5, 11, 20};
        Set<Integer> noDupes = new LinkedHashSet<>();

        for (String s : strArr) {
            for (int n : numArr) {
                noDupes.add(n);
            }
            noDupes.add(Integer.parseInt(s));
        }

        Integer[] newArr = noDupes.toArray(new Integer[noDupes.size()]);

        System.out.println("New Array: "+ Arrays.toString(newArr));
    }

    public Object[] combineArr (Object[] one, Object[] two) {
        Set<Object> noDupes = new LinkedHashSet<>();

        for (Object o : one) {
            for (Object o1 : two) {
                noDupes.add(o1);
            }
            noDupes.add(o);
        }
        Object[] newArr = noDupes.toArray(new Object[noDupes.size()]);

        return newArr;
    }
}
