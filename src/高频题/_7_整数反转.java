package 高频题;

/** https://leetcode-cn.com/problems/reverse-integer/
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class _7_整数反转 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            int mod = x % 10;
            res = res * 10 + mod;
            /// 判断是否溢出
            if ((res - mod) / 10 != prevRes) return 0;
            x /= 10;
        }
        return res;
    }

    public int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE) return 0;
            if (res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        _7_整数反转 o = new _7_整数反转();
        System.out.println(o.reverse(-1234));
        System.out.println(o.reverse(1234));
        System.out.println(o.reverse(1200));
        System.out.println(o.reverse(Integer.MAX_VALUE));
        System.out.println(o.reverse(Integer.MIN_VALUE));
    }
}
