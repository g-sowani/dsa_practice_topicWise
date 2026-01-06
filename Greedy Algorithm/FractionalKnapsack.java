import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    static class Item {
        int val;
        int weight;
        double ratio;

        public Item(int value, int weight, double ratio) {
            this.val = value;
            this.weight = weight;
            this.ratio = ratio;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter capacity");
        int capacity = sc.nextInt();
        System.out.println("Enter numebr of items");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value of item " + (i+1));
            int val = sc.nextInt();

            System.out.println("Enter weight of item " + (i+1));
            int weight = sc.nextInt();

            Item item_i = new Item(val, weight, ((double)(val)/(double)(weight)));

            items[i] = item_i;
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare(b.ratio, a.ratio);
            }
        });

        double score = 0;
        double available_w = (double)(capacity);
        for(Item item: items){
            double weight = (double)(item.weight);
            double val = (double)(item.val);
            
            if(weight< available_w){
                score += val;
                available_w -= weight;
            } else {
                score += item.ratio * available_w;
                available_w = 0;
                break;
            }
        }
        System.out.println(score);
    }
}
