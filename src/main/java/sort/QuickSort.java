package sort;
/*
 *快排
 * https://www.pdai.tech/md/algorithm/alg-sort-x-fast.html
 */
public class QuickSort {
    /*
     * arr -- 待排序数组
     * n -- 数组长度
     */
    public static void sort(int[] arr,int n){
        sort(arr,0,n-1);
    }
    public static void sort(int[] arr,int low,int high){
        int start = low;
        int end = high;
        int key = arr[start];
        while(start<end){
            while(start<end && arr[end]>=key){
                end--;
            }
            arr[start] = arr[end]; //第一次循环第一次交换，10放到20的位置 [10,40,30,10,60,50]
            while(start<end && arr[start]<=key){
                start++;
            }
            arr[end] = arr[start]; //第一次循环第二次交换，40放到原来10的位置 [10,40,30,40,60,50]
        }
        arr[start] = key;
        if(start>low){
            sort(arr, low, start-1);
        }
        if(end<high){
            sort(arr, end+1,high);
        }
    }

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        sort(a, a.length);

        System.out.printf("after  sort:");
        for (int i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}
