package PracticeLang;

public class intToStr {
    public static void main(String[] args) {
        String s = "12345";
        int n = 0;
        for ( int i = 0; i < s.length(); i++) {
            n += s.charAt(i) * 10;
        }
        System.out.println(n);
    }
    public int strConvert (String number){
        int n = 0;
        for (int i= number.length(); i > 0; i--) {
            n += number.charAt(i) * 10;
        }
        return n/10;
    }
}
