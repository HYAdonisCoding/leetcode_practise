package 高频题;

/** https://leetcode-cn.com/problems/powx-n/
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class _50_Pow_x_n {
    /// 非递归
    public double myPow2(double x, int n) {
        boolean neg = n < 0;
        long y = neg ? -((long)n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                /// 如果最后一个二进制为是1就累乘上x
                res *= x;
            }
            x *= x;
            // 舍弃掉最后一位二进制位
            y >>= 1;
        }
        return neg ? (1 / res) : res;
    }
    /// 递归
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        // 是否为基数
        boolean odd = (n & 1) == 1;
        double half = myPow(x, n >> 1);
        half *= half;
        /// 是负数
//        x = n < 0 ? (1 / x) : x;
        return odd ? (half * x) : half;
    }

    /** 请设计一个算法求 的 次幂模 的结果：x^y%z
     * 假设 、 都可能是很大的整数
     * y >=0, z != 0
     * 公式须知
     * (a * b) % p == ((a % p) * (b % p)) % p
    * @Description:
    * @Param:  
    * @return:  
    * @Author: Adam
    * @Date: 2022/2/21 
    */
    public int powMod2(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        int res = 1 % z;
        while (y > 0) {
            if ((y & 1) == 1) {
                /// 如果最后一个二进制为是1就累乘上x
                res = (res * x) % z;
            }
            x = (x * x) % z;
            // 舍弃掉最后一位二进制位
            y >>= 1;
        }
        return  res;
    }
    /**
     * 递归
     * 2^100 % 6 = (2^50 * 2^50) % 6 = ((2^50 % 6) * (2^50 % 6))) % 6
     * 2^101 % 6 = (2^50 * 2^50 * 2) % 6 = ((2^50 % 6) * (2^50 % 6) * (2 % 6))) % 6
     * */
    public int powMod(int x, int y, int z) {
        if (y < 0 || z == 0) return 0;
        if (y == 0) return 1 % z;
        int half = powMod(x, y >> 1, z);
        half *= half;
        return  ((y & 1) == 0) ? (half % z) : ((half * (x % z)) % z);
    }
    
    public static void main(String[] args) {
        /// 快速幂
        _50_Pow_x_n o = new _50_Pow_x_n();
        System.out.println(o.myPow2(2, 10));

        System.out.println(o.myPow2(2, -2));

        int n = -7;
        System.out.println(n / 2);
        System.out.println(n >> 1);

        System.out.println(o.powMod2(-123, 455, 789));
        System.out.println(o.powMod(-123, 455, 789));

    }
}
