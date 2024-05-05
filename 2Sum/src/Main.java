import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 6, 9, 1, 5, 11}; // 14

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            int val = arr[i];
            int target = 14 - val;

            if(map.containsKey(target)){
                System.out.println("pair " + i + " " + map.get(target));
            }
            map.put(val,i);
        }
    }
}