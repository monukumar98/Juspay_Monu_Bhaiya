package Graph;
import java.util.*;
public class Maximum_Weight_Node {
    public static void main(String args[]) {
       Scanner sc =new Scanner(System.in);
       int n=sc.nextInt();
       int [] arr = new int [n];
       for(int i=0; i<n; i++){
       arr [i]= sc.nextInt();
       }
       System.out.println(maxWeightCell(n,arr));
    }
    public static int maxWeightCell(int n, int[] edge) {
        int[] cnt = new int[n];
        Arrays.fill(cnt, 0); // Initialize the array with 0

        for (int i = 0; i < n; i++) {
            if (edge[i] != -1) {
                cnt[edge[i]] += i;
            }
        }

        int ans = -1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (maxi <= cnt[i]) {
                maxi = cnt[i];
                ans = i;
            }
        }

        return ans;
    }
}