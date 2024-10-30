package Unit0.School;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classroom {
    private String name;
    private Student[][] seatingChart;
    public Classroom(String name, int rows, int cols) {
        this.name = name;
        this.seatingChart = new Student[rows][cols];
    }
    public String getName() {
        return this.name;
    }
    public void assignStudent(Student student, int row, int col) {
        this.seatingChart[row][col] = student;
    }
    public Student getStudent(int row, int col) {
        return this.seatingChart[row][col];
    }
    public int getNumStudents() {
        int count = 0;
        for(Student[] row : seatingChart) {
            for(Student student : row) {
                if(student != null) {
                    count++;
                }
            }
        }
        return count; 
    } 
    public void addStudents(List<Student> students) {
        // Create a copy
        students = new ArrayList<>(students);
        for(int i = students.size() - 1; i >= 0; i--) {
            Student currentStudent = students.remove(i);
            int row = -1;
            int col = -1;
            for(int j = 0; j < seatingChart.length; j++) {
                for(int k = 0; k < seatingChart[j].length; k++) {
                    if(seatingChart[j][k] == null) {
                        row = j;
                        col = k;
                    }
                }
            }
            seatingChart[row][col] = currentStudent;
        }
    }
    public String toString() { 
        return "Name: " + this.name + ", Students: " + Arrays.deepToString(seatingChart);
    }
}