package week2;


public class hello {
    public static void main(String[] args) {
              
        char[] charArray = {'J', 'a', 'v', 'a'};
        String fromArray = new String(charArray);
        System.out.println("this is" + fromArray); 
    
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");     
        sb.append("World!");
        String result=sb.toString();
        System.out.println(result);

        String str1="hello";
        str1=str1+" world"+fromArray;
        System.out.println(str1);

        System.out.println(str1.equals(sb));


        StringBuilder demo = new StringBuilder("Java Programming");
        demo.replace(5, 16, "Development");
        System.out.println("After replace: " + demo);
    }

}
