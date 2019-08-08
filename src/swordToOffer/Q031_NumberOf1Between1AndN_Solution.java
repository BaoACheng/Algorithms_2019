package swordToOffer;


public class Q031_NumberOf1Between1AndN_Solution {
    /*
     * 问题描述:
     *  求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6
     *  次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
     *  （从1 到 n 中1出现的次数）。
     * 解决思路(初始):
     *  简单来说，该问题想要考察的能力是数字的逐位判断，那么我们就可以对数字逐步取余，得到相应的位的数字，然后将数字后移，即除以10，即可逐步得到
     *  该位上的数字，然后与1进行判定即可。
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  1、在读题上发生错误，理解为包含1的数字，而在数字11中，1出现了2次，会在思路上认为1次
     *  2、在写for循环时，由于判定的是1~n的数字，但没有包含数字n，因此出现错误
     * Tips:
     *
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int existTime = checkExistTimeOf1(i);
            if(existTime!=0)
                count+=existTime;
        }
        return count;
    }

    public int checkExistTimeOf1(int number){
        int count = 0;
        while(number>0){
            if(number%10 == 1)
                count++;
            number/=10;
        }
        return count;
    }

    public static void main(String[] args) {
        Q031_NumberOf1Between1AndN_Solution exist = new Q031_NumberOf1Between1AndN_Solution();
        System.out.println(exist.NumberOf1Between1AndN_Solution(55));
    }
}
