package Beike;

import java.util.ArrayList;
import java.util.Scanner;

public class Q002_getMissing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int[] index = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            index[i] = Integer.parseInt(temp[i]);
        }
        int nums = index[0] + 1;
        int[] all;
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; ; i++) {
            all = getAll(i);
            list = compare(deepCopy(index), all);
            if(list.size() !=0){
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            index[list.get(i)]++;
        }
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num = num*10+list.get(i);
        }
        int cardNum = 0;
        for (int i = 0; ; i++) {
            all = getAll(i);
            list = compare(deepCopy(index), all);
            if(list.size() == 0){
                cardNum = i;
                break;
            }
        }
        System.out.println(cardNum+" "+num);
    }

    public static ArrayList compare(int[] card, int[] all){
        ArrayList list = new ArrayList();
        for (int i = 0; i < card.length; i++) {
            card[i]-=all[i];
            if (card[i]<0)
                list.add(i);
        }
        return list;
    }

    public static int[] deepCopy(int[] arr){
        int len = arr.length;
        int[] res = new int[arr.length];
        for (int i = 0; i < len; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] getAll(int num){
        int[] res = new int[10];
        for (int i = 1; i <= num; i++) {
            while(i!=0){
                int temp = i%10;
                res[temp]++;
                i/=10;
            }
        }
        return res;
    }
}
