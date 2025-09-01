package week2.week1;
public class StringManipulation{
public static void main(String[] args) {  
// TODO: Create the same string "Java Programming" using 3different methods: 


String str1 = "Java Programming";

String str2 = new String("Java Programming");


char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
String str3 = new String(charArray);


boolean isEqualUsingDoubleEquals = (str1 == str2); 
boolean isEqualUsingEquals = str1.equals(str2); 

System.out.println("Using '==': " + isEqualUsingDoubleEquals); // false
System.out.println("Using '.equals()': " + isEqualUsingEquals); // true

}
}