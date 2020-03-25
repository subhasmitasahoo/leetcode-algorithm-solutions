//Problem link: https://leetcode.com/problems/apply-discount-every-n-orders/submissions/

//Time complexity: O(product_length) for each getBill() method
//Space complexity: O(product_length) in total
class Cashier {

    Map<Integer, Integer> prodPrice;
    int custNum, curNum = 0;
    int disc;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        custNum = n;
        disc = discount;
        prodPrice = new HashMap();
        for(int i=0; i<products.length; i++) {
            prodPrice.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        curNum++;
        double res = 0;
        for(int i=0; i<product.length; i++) {
            res += amount[i]*prodPrice.get(product[i]);
        }
        if(curNum == custNum) {
            res -= (res*disc)/100;
            curNum = 0;
        }
        return res;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
