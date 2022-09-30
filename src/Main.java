/*import java.io.File;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static boolean AllVowels(String word){
        if(word.equals(""))
            return false;
        int n = word.length();
        int count = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'а', 'е', 'є', 'и', 'і', 'ї', 'о', 'у', 'ю', 'я'};
        for (char vowel : vowels) {
            count += word.chars().filter(ch -> ch == vowel).count();
            if(count == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("words.txt"));

        var words = new HashSet<String>();

        while(reader.hasNext()){
            var w = reader.next().toLowerCase().replaceAll("[^(a-zа-яії)]", "");
            if(w.length() > 30)
                w = w.substring(0, 30);
            if(AllVowels(w))
                words.add(w);
        }
        reader.close();
        System.out.println(words);
    }
}*/
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> result = new java.util.ArrayList<>(Collections.emptyList());

        Scanner scanner = new Scanner(System.in);
        //String fileName = scanner.nextLine();
        String fileName = "words.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        Pattern softPattern = Pattern.compile("\\b\\p{L}{1,30}");
        Pattern hardPattern = Pattern.compile("\\b.*([^aeiou])\\1{1,}.*\\b");


        String textString;

        while((textString = reader.readLine()) != null){
            Matcher softMatcher = softPattern.matcher(textString);
            while(softMatcher.find()) {
                Matcher hardMatcher = hardPattern.matcher(softMatcher.group().toLowerCase());
                while(hardMatcher.find()){
                    if(!result.contains(softMatcher.group()))
                        result.add(softMatcher.group());
                }
            }
        }


        for (String word : result) {
            System.out.println(word);
        }
    }
}