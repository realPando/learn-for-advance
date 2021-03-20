package code;

//大顶堆
public class FindKthMax2 {
    public static int findKthLargest(int[] nums, int k) {
        int index = nums.length-k;
        for(int i=nums.length/2-1;i>=0;i--){
            headSort(nums,i,nums.length);
        }
        for(int i=nums.length-1;i>index;i--){
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            headSort(nums,0,i+1);
        }
        return nums[0];
    }

    public static void headSort(int[] nums, int c, int length) {
        int tmp = nums[c];
        for (int i = 2 * c + 1; i < length; i = 2 * i + 1) {
            if (i+1<length && nums[i] < nums[i+1]) {
                i++;
            }
            if (tmp >= nums[i]) {
                break;
            } else {
                nums[c] = nums[i];
                c = i;
            }
        }
        nums[c] = tmp;
    }

    public static void main(String[] args) {
        int i;
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

                  // 升序排列
        //heapSortDesc(a, a.length);        // 降序排列
        System.out.println(findKthLargest(a, 2));
        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
