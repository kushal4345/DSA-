package String;

public class BasicOperations {
    public static void main(String args[]){
        String s = "hello";
         s = " helllo@@o   ";
         String k = " h";

//         System.out.print(s.equals(k));
        // insert opertaion start

        StringBuilder sb = new StringBuilder("hello");
//        sb.append("4");
//        System.out.println(sb);
        sb.insert(1,"ass");
        System.out.println(sb);
        sb.deleteCharAt(1);
        sb.delete(2,5);
        s.replaceAll("e","");
        sb.indexOf("hel"); // give starting index of substring
  sb.reverse();
  String m= "hello what are you    ";
  String words[] = m.trim().split(" ");
  for(String w: words){
      System.out.println(w);
  }
    }
}
