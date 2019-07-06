package sword_to_offer;


public class Q046_LastRemaining {
    /*
     * 问题描述:
     *  每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是
     *  这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以
     *  在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表
     *  演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * 解决思路(初始):
     *  使用的数据结构为数组，每找到一个小朋友，则将该位置的值置为-1，然后从该位置靠后的index+m，若index+m-1>n,则新的下标为Index+m-1-n。
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public int LastRemaining_Solution(int n, int m) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        int count = 0, i = 0, step = 0;
        while (count < n) {
            //数组越界，则直接置为起点
            if (i == n)
                i = 0;
            if (array[i] == -1) {
                i++;
                continue;
            }
            step++;
            i++;
            //每当找到一个目标位置，则将该位置置为-1
            if (step == m) {
                array[i] = -1;
                count++;
                step = 0;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        Q046_LastRemaining last = new Q046_LastRemaining();
        System.out.println(last.LastRemaining_Solution(5,2));
    }
}
