package sword_to_offer;

public class Q012_PowerWithUnsignedExponent {
    /*
     * 问题描述:
     *  给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 解决思路(初始):
     *  通过不断乘积的形式来实现整数次幂，并判断，当exponent为负数时，先取绝对值，然后整体取倒数。
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */

    public double PowerWithUnsignedExponent(double base, int exponent) {
        if (base == 0 || base == 1)
            return base;
        if (exponent == 0)
            return 1.0;
        double result = 1.0;

        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }

        return exponent<0?1/result:result;
    }
}
