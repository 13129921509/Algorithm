import java.util.LinkedList;
import java.util.Queue;

public class median_of_two_sorted_arrays_4 {
    public static void main(String[] args) {
        median_of_two_sorted_arrays_4.findMedianSortedArrays(new int[]{1}, new int[]{1});
    }

    /**
     * [100,200,300,400,700]
     * [50,80,250,350]
     * 采用合并数组的方法，排列数组，然后取中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int i = 0,j = 0;
        while (i<nums1.length&&j<nums2.length){
            if (i<nums1.length&&j<nums2.length&&nums1[i]>=nums2[j]){
                while (i<nums1.length&&j<nums2.length&&nums1[i]>nums2[j]){
                    queue.offer(nums2[j]);
                    j++;
                }
                queue.offer(nums1[i]);
                i++;
            }
            if (i<nums1.length&&j<nums2.length&&nums1[i]<=nums2[j]){
                while (i<nums1.length&&j<nums2.length&&nums1[i]<nums2[j]){
                    queue.offer(nums1[i]);
                    i++;
                }
                queue.offer(nums2[j]);
                j++;
            }
        }

        while ( i == nums1.length){
            while (j<nums2.length){
                queue.offer(nums2[j]);
                j++;
            }
            break;
        }
        while ( j == nums2.length){
            while (i<nums1.length){
                queue.offer(nums1[i]);
                i++;
            }
            break;
        }
        double a = 0;
        if (queue.size()%2 == 0){
            a = Double.valueOf((((LinkedList<Integer>) queue).get(queue.size()/2)+((LinkedList<Integer>) queue).get(queue.size()/2-1)))/2;
            return a;
        }else{
            a = Double.valueOf((((LinkedList<Integer>) queue).get(queue.size()/2)));
            return a;
        }
    }
}
