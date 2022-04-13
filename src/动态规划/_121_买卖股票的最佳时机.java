package 动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author adam
 *
 */
public class _121_买卖股票的最佳时机 {
	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}
		/// 前面扫描过的最小价格
		int minPrice = prices[0];
		/// 前面扫描过的最小价格
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else {
				/// 把第i天的股票卖出
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 示例 1：
		 * 
		 * 输入：[7,1,5,3,6,4] 输出：5 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 =
		 * 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
		 * 
		 * 示例 2：
		 * 
		 * 输入：prices = [7,6,4,3,1] 输出：0 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
		 * 
		 */
	}

}
