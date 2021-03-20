package sort;
/**
 * 堆排序: Java
 *
 * @author skywang
 * @date 2014/03/11
 */

public class HeapSort {

    /*
     * (最大)堆的向下调整算法
     *
     * 注: 数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
    public static void maxHeapDown(int[] array, int k, int length) {
        int temp = array[k]; //堆顶节点
        for (int i = 2*k+1; i < length; i = 2*i+1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i+1< length && array[i] < array[i + 1]) {  //如果左孩子小于右孩子
                i++;   //则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //堆顶节点 >=左右孩子中较大者，调整结束
                break;
            } else {   //根节点 < 左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被堆顶结点的值放人最终位置
    }


    /*
     * 堆排序(从小到大)
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void heapSortAsc(int[] a, int n) {
        int i,tmp;

        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--)
            maxHeapDown(a, i, a.length);

        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(a, 0, i); //i是调整后的数组长度
        }
    }

    public static void minHeapDown(int[] a, int c,int length) {
        int tmp = a[c];
        for(int i =2*c+1;i<length;i=2*i+1){
            if(i+1<length && a[i]>a[i+1]){
                i++;
            }
            if(a[c]<a[i]){
                break;
            }else{
                a[c] = a[i];
                a[i] = tmp;
                c = i;
            }
        }
        a[c] = tmp;
    }

    /*
     * 堆排序(从大到小)
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void heapSortDesc(int[] a, int n) {
        int i,tmp;

        // 从(n/2-1) --> 0逐次遍历每。遍历之后，得到的数组实际上是一个最小堆。
        for (i = n / 2 - 1; i >= 0; i--)
            minHeapDown(a, i, n);

        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最小的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最小堆。
            // 即，保证a[i-1]是a[0...i-1]中的最小值。
            minHeapDown(a, 0, i);
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//        heapSortAsc(a, a.length);            // 升序排列
        heapSortDesc(a, a.length);        // 降序排列

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}