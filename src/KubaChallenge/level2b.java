package KubaChallenge;

import java.util.*;

public class level2b {
    String name;
    int age;
    double height;
    level2b(String n, int a, double h) {
        this.name = n;
        this.age = a;
        this.height = h;
    }
    public static void main(String[] args) {
        level2b l2b = new level2b("Mark",30,5.5);

        String cities = "NYC, Washington DC, Boston, LA";
        List<String> ctls = new ArrayList<>(Arrays.asList(cities.split(", ")));
        Set<String> ctst = new LinkedHashSet<>(ctls);
        ctls.add(1,"LA");
        ctls.remove(2);
        ctls.add(3,"Washington DC");
        ctls.remove(4);
        Collections.sort(ctls);
        System.out.println(ctls);
        System.out.println(ctst);
        Map<String,Integer> ctmp = new LinkedHashMap<>();
        int i = 1;
        for(String s : ctst){
            ctmp.put(s,i++);
        }
        System.out.println(ctmp);
    }
}
