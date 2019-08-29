package MeiTuan;

import java.util.Scanner;

public class Q002_FindSubStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] arr = new String[num];
        String[] temp;
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextLine();
        }
        while (sc.hasNext()){
            temp = sc.nextLine().split(" ");
            int index1 = temp[0].charAt(0)-'0';
            int index2 = temp[1].charAt(0)-'0';
            if(index1<=0||index1>num||index2<=0||index2>num)
                System.out.println();
            else
                System.out.println(Compare(arr[index1], arr[index2]));
        }
    }
    public static int Compare(String str1, String cmpStr){
       return 0;
    }
}
