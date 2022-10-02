import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader3000 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/oleksandr/test.txt");
        Scanner scanner = new Scanner(file);
        List<String> wordList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
        String word;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                word = matcher.group();
                boolean correct = true;
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < word.length(); i++) {
                    var current = String.valueOf(word.charAt(i)).toLowerCase();
                    if (map.get(current) == null) {
                        map.put(current, "");
                    } else {
                        correct = false;
                        break;
                    }
                }
                if (correct) {
                    wordList.add(word);
                }
            }

        }
        Collections.sort(wordList);
        String previous = "";
        for (String s : wordList) {
            if (!Objects.equals(s, previous)) {
                System.out.println(s);
            }
            previous = s;
        }
    }
}
