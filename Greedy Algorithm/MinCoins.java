import java.util.ArrayList;

public class MinCoins {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500 };
        int amount = 857;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int low = 0;
        int high = coins.length;
        while(amount>0){
            int selected = binarySearch(coins, low, high, amount);
            amount -= coins[selected];
            high = selected+1;
            list.add(coins[selected]);
        }
        for(int item: list){
            System.out.println(item);
        }

    }

    public static int binarySearch(int[] coins, int low, int high, int amount) {
        int mid = (low + high) / 2;
        while (low < high) {

            if (coins[mid] == amount) {
                return mid;
            } else if (coins[mid] > amount) {
                return binarySearch(coins, low, mid, amount);
            } else {
                return binarySearch(coins, mid+1,high, amount);
            }
        }

        return mid-1;
    }
}
