package code;

//小顶堆
public class FindKthMax3 {

    public static void minHeapDown(int[] nums, int c, int length){
        int tmp = nums[c];
        for(int i=2*c+1;i<length;i=2*i+1){
            if(i+1<length && nums[i]>nums[i+1]){
                i++;
            }
            if(nums[c]<nums[i]){
                break;
            }else{
                nums[c] = nums[i];
                nums[i] = tmp;
                c = i;
            }
        }
        nums[c] = tmp;
    }

    public static int heapSort(int[] nums,int k){
        for(int i=k/2-1;i>=0;i--){
            minHeapDown(nums,i,k);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>nums[0]){
                int tmp = nums[i];
                nums[i] = nums[0];
                nums[0] = tmp;
                minHeapDown(nums,0,k);
            }
        }
        return nums[0];
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
        System.out.println(heapSort(a, 2));
        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
