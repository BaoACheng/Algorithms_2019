package sort_algorithms;

public class Public_method {

    int[] a = {1, 3, 2, 6, 5, 4, 11, 9, 0, -2, -5};

    public void print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public void bubble(){
        Bubble_sort bs = new Bubble_sort();
        int[] b = bs.bubble_sort_rev(a);
        print(b);
    }

    public void select(){
        Select_sort ss = new Select_sort();
        int[] b = ss.select_sort(a);
        print(b);
    }

    public void insert(){
        Insert_sort is = new Insert_sort();
        int[] b = is.insert_sort(a);
        print(b);
    }

    public void merge(){
        Merge_sort ms = new Merge_sort();
        ms.merge_sort(a);
        print(a);
    }

    public static void main(String args[]){
        Public_method pm = new Public_method();
        pm.merge();
    }
}
