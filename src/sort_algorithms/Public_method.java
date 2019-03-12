package sort_algorithms;

public class Public_method {

    public void print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String args[]){
        Public_method pm = new Public_method();
        int[] a = {1, 3, 2, 6, 5, 4};
        Bubble_sort bs = new Bubble_sort();
        int[] b = bs.bubble_sort_rev(a);
        pm.print(b);
    }
}
