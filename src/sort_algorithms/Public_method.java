package sort_algorithms;

public class Public_method {

    int[] a = {1, 3, 2, 6, 5, 4, 11, 9, 0, -2, -5};
    int[] c = {11, 22, 21, 35, 92, 87, 64, 39};

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void bubble() {
        Bubble_sort bs = new Bubble_sort();
        int[] b = bs.bubble_rev(a);
        print(b);
    }

    public void select() {
        Select_sort ss = new Select_sort();
        int[] b = ss.select(a);
        print(b);
    }

    public void insert() {
        Insert_sort is = new Insert_sort();
        int[] b = is.insert_sort(a);
        print(b);
    }

    public void merge() {
        Merge_sort ms = new Merge_sort();
        ms.merge(a);
        print(a);
    }

    public void shell() {
        Shell_sort ss = new Shell_sort();
        int[] b = ss.shell(a);
        print(b);
    }

    public void quick() {
        Quick_sort qs = new Quick_sort();
        int[] b = qs.quick(a, 0, a.length - 1);
        print(b);
    }

    public void heap() {
        Heap_sort hs = new Heap_sort();
        int[] b = hs.heap_sort(a);
        print(b);
    }

    public void radio() {
        Radio_sort ra = new Radio_sort();
        int[] b = ra.radio(c, 100);
        print(b);
    }

    public static void main(String args[]) {
        Public_method pm = new Public_method();
        pm.radio();
    }
}
