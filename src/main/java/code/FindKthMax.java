package code;

public class FindKthMax {

    public static int sort(int[] arr,int n,int k){
        int loc = n-k;
        sort(arr,0,n-1,loc);
        return arr[loc];
    }

    public static void sort(int[] arr,int low,int high,int loc){
        int start = low;
        int end = high;
        int key = arr[start];
        while(start<=end){
            while(start<=end && arr[end]>=key){
                end--;
            }
            arr[start] = arr[end];
            while(start<=end && arr[start]<=key){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = key;
        if(loc<start){
            sort(arr,low,start-1);
        }else{
            sort(arr,end+1,high);
        }
    }
}
