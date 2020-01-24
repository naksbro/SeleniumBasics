package KubaChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class level2c {
    public static void main(String[] args) {
        File f = new File("/Users/admin/Desktop/TLA/test/names.txt");
        try(BufferedReader rdr = new BufferedReader(new FileReader(f))){
            String line;
            while((line = rdr.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e) {
            System.err.println(e.getMessage());
        }

        List<String> ls1 = new ArrayList<>();
        List<String> ls2 = new ArrayList<>();
        Map<String, String> mp = new LinkedHashMap<>();


    }
}
