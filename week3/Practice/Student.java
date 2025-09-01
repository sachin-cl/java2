package week3.Practice;

public class Student {
    
    private String studentId;
    private String name;
    private double grade;
    private String course;


    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }


    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getter and Setter methods
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

   
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Course: " + course);
        System.out.println("Letter Grade: " + calculateLetterGrade());
    }

    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.setStudentId("S101");
        s1.setName("Alice");
        s1.setGrade(85.5);
        s1.setCourse("Mathematics");

      
        Student s2 = new Student("S102", "Bob", 72.0, "Physics");

 
        System.out.println("Student 1 Name (getter): " + s1.getName());
        s2.setGrade(95.0); 

        System.out.println("\nStudent 1 Info:");
        s1.displayStudent();
            
        System.out.println("\nStudent 2 Info:");
        s2.displayStudent();
    }
}