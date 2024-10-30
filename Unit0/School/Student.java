package Unit0.School;

public class Student {
    //fields
    private int id;
    private String name;
    private int grade;
    //constructor
    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    //methods
    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getGrade() {
        return this.grade;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Name is non-blank
     * ID > 0
     * Grade >= 9 and <= 12
     * @return
     */
    public boolean checkValid() {
        return this.id > 0 && name != null && !this.name.trim().isEmpty() && this.grade >= 9 && this.grade <= 12;
    }
    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", grade: " + this.grade;
    }
}