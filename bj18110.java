import java.io.*;

public class Main {
    static int[] array;
    public static void mergeSort(int[] arr,int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int j = left;
        int k = mid+1;
        int i =left;
        while(j<=mid && k<=right){
            if(arr[j]<=arr[k]){
                array[i++] = arr[j++];
            }else {
                array[i++] = arr[k++];
            }
        }
        if(j>mid){
            while(k<=right){
                array[i++]=arr[k++];
            }
        }else{
            while(j<=mid){
                array[i++]=arr[j++];
            }
        }
        for(int m = left; m<=right; m++){
            arr[m] = array[m];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        array = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(num,0,n-1);
        double cut_range = Math.round(((double)n*15)/100);
        int[] cut_num = new int[n-2*(int)cut_range];
        System.arraycopy(num,(int)cut_range,cut_num,0,n-2*(int)cut_range);
        double sum=0;
        for(int i = 0; i<cut_num.length; i++){
            sum+=cut_num[i];
        }
        sum = Math.round(sum/cut_num.length);
        bw.write(String.valueOf((int)sum));
        bw.flush();
        bw.close();
    }
}
