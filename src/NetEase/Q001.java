package NetEase;

public class Q001 {

    public static int getmaxDivisor(int a,  int b) {
        if (a < b) {
            int tmp = b;
            b = a;
            a = tmp;
        } else if (a == b) {
            return b;
        } else {
            if ((a & 1)!=0 && (b & 1)!=0) {
                a = a >> 1;
                b = b >> 1;
                getmaxDivisor(b, a - b);
            } else if ((a & 1)!=0 && (b & 1)==0) {
                a = a >> 1;
                getmaxDivisor(b, a - b);
            } else if ((a & 1)==0 && (b & 1)!=0) {
                b = b >> 1;
                getmaxDivisor(b, a - b);
            } else {
                getmaxDivisor(b, a - b);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getmaxDivisor(16, 64));
    }
}
