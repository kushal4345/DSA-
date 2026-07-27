package String;
import java.util.*;
class long_pressed {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String typed = sc.nextLine();

        int i = 0, j = 0;
        while (i != name.length() && j != typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == name.length()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
