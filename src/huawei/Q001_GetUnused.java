package huawei;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q001_GetUnused {
    public static void main(String[] args) throws IOException {
        System.setIn(new BufferedInputStream(new FileInputStream("resource\\huawei001.txt")));
        Scanner sc = new Scanner(System.in);
        String strSet = sc.nextLine();
        String[] strArr = strSet.split("@");
        if (strArr.length == 1) {
            System.out.println(strArr[0]);
        } else {
            if (strArr[0].length() == 0) {
                return;
            } else {
                String allStr = strArr[0];
                String usedStr = strArr[1];

                String notUsedStr = getNotUseStr(allStr, usedStr);
                System.out.println(notUsedStr);
            }
        }
    }
    // 传入数据为 全部可用集， 已使用集
    public static String getNotUseStr(String allStr, String usedStr) {

        String notUsedStr = "";
        String[] allStrArr = allStr.split(",");
        String[] usedStrArr = usedStr.split(",");

        int index = 0;
        for (int i = 0; i < usedStrArr.length; i++) {
            String[] oneUsed = usedStrArr[i].split(":");
            String[] defineStr = allStrArr[index].split(":");
            while (!defineStr[0].equals(oneUsed[0])) {
                if (notUsedStr.length() == 0) {
                    notUsedStr += allStrArr[index++];
                } else {
                    notUsedStr += "," + allStrArr[index++];
                }
                defineStr = allStrArr[index].split(";");
            }

            int sub = Integer.parseInt(defineStr[1]) - Integer.parseInt(oneUsed[1]);
            if (sub > 0) {
                if (notUsedStr.length() == 0) {
                    notUsedStr += defineStr[0] + ":" + sub;
                } else {
                    notUsedStr += "," + defineStr[0] + ":" + sub;
                }
            }
            index++;
        }
        while (index < allStrArr.length) {
            notUsedStr += "," + allStrArr[index++];
        }
        return notUsedStr;
    }
}
