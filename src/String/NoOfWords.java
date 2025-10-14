package String;

public class NoOfWords {
    public static void main(String[] args) {
        int count = 1;

        String s = "  hello  everyone  i hope  you are doing well  ";
        s = s.trim(); // remove leading and trailing spaces

        String[] words = s.split("\\s+"); // split by one or more spaces [ "hello" , "this" ......]
        System.out.println(words.length);

    }
}
