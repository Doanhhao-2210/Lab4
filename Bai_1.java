import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Bai_1 { 
    private HashMap<String, String> dictionary;

    public Bai_1() {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("goodbye", "tam biet");
        dictionary.put("eat", "an");
        dictionary.put("sleep", "ngu");
        dictionary.put("dog", "con cho");
        dictionary.put("pen", "cay but");
        dictionary.put("school", "truong hoc");
        dictionary.put("friend", "ban be");
        dictionary.put("mother", "me");
        dictionary.put("father", "ba");
    }
    public boolean existWord(String word) {
        Set<String> keys = dictionary.keySet();
        return keys.contains(word);
    }
    public String meaning(String word) {
        return dictionary.get(word);
    }
    public String get(String word) {
        if (existWord(word)) {
            return dictionary.get(word);
        } else {
            return "Khong co tu '" + word + "' trong tu dien";
        }
    }   
    
    public static void main(String[] args) {
         Bai_1 dict = new Bai_1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap tu can tra:");

        while (true) {
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("Thoat")) {
                break;
            }
            System.out.println("Nghia cua tu'" + word + "' la: " + dict.get(word));
        }

        scanner.close();
    }
}



