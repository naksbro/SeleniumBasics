package KubaChallenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaClass {
    String filePath;
    String movieTitle;
    int movieRating;
    int movieRuntime;
    String genre;
    static Map<String, List<String>> mpls = new HashMap<>();

    public JavaClass(String s, String mt, String mp) {
        this.filePath = mp;
        this.movieTitle = mt;
    }

    private String getFileContent(String path) {
        File f = new File(path);
        StringBuilder sb = new StringBuilder();

        try(InputStream in = new FileInputStream(f)){
            int b;
            while((b = in.read()) != -1) {
                sb.append((char)b);
            }
        }catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return sb.toString();
    }

}
