package PracticeLang;

public class recursion {
    public static void main(String[] args) {
        System.out.println(reverse("looc si noisrucer"));
    }
    public static String reverse (String str) {
        if (str.length() <= 1)
            return str;
        else
            return reverse(str.substring(1))+str.charAt(0);
    }
}
