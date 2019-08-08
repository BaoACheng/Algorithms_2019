package simpleCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T001_Collections_sort {

    public static List<Student> sort_test(List<Student> list) {

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double dis1 = Math.sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2));
                double dis2 = Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2));
                if (dis1 > dis2)
                    return -1;
                else
                    return 1;

            }
        });
        return list;
    }

    public static void main(String[] args) {
        Student s1 = new Student(5, 5);
        Student s2 = new Student(8, 8);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list = sort_test(list);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).x);
        }
    }
}

class Student {
    int x;
    int y;

    public Student(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
