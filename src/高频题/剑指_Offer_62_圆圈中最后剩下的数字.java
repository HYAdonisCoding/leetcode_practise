package 高频题;

/** https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class 剑指_Offer_62_圆圈中最后剩下的数字 {
    /** 递归
    * @Description:  计算公式 f(n, m) = (f(n-1, m) + m) % n  其实就是著名的约瑟夫环问题
    * @Param:
    * @return:
    * @Author: Adam
    * @Date: 2022/2/21
    */
    public int lastRemaining1(int n, int m) {
        return (n == 1) ? 0 :(lastRemaining1(n - 1, m) + m) % n;
    }

    /** 非递归
     * @Description:  计算公式 f(n, m) = (f(n-1, m) + m) % n  其实就是著名的约瑟夫环问题
     * @Param:
     * @return:
     * @Author: Adam
     * @Date: 2022/2/21
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {// i是数据规模，代表有多少个数字（多少个人）
            res = (res + m) % i;

        }
        return res;
    }

        public static void main(String[] args) {
        剑指_Offer_62_圆圈中最后剩下的数字 o = new 剑指_Offer_62_圆圈中最后剩下的数字();
        System.out.println(o.lastRemaining1(5, 3));;//3
        System.out.println(o.lastRemaining1(10, 17));;//2
            System.out.println(o.lastRemaining(5, 3));;//3
            System.out.println(o.lastRemaining(10, 17));;//2
    }
}
