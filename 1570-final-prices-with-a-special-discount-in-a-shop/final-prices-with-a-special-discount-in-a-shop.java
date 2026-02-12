import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < prices.length; i++) {
            // While current price is <= price at stack top index
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                prices[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}