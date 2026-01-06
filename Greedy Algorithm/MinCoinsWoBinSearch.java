import java.util.ArrayList;

public class MinCoinsWoBinSearch {
    public static void main(String[] args) {
        int[] coins = {1,2,5,10,20,50,100,500};
        int amount = 853;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = (coins.length-1) ; i>=0;i--){
            while(amount>=coins[i]){
                amount -= coins[i];
                list.add(coins[i]);
            }

        }
        for(int item: list){
            System.out.println(item);
        }
    }
}
