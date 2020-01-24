package KubaChallenge;

import java.util.Arrays;

public class level2a {
    public static void main(String[] args) {
        String str = "Java 8 is most common used version nowadays";
        str = str.replace("Java", "JAVA");
        str = str.replace("8","12");
        String[] strArr = str.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String s = strArr[i];
            s = s.substring(0,1).toUpperCase()+s.substring(1);
            strArr[i] = s;
        }
        str = "";
        for(String s : strArr){
            str += s+" ";
        }
        System.out.println(str);
    }
}
