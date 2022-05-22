import java.util.Scanner;

class MaxHeap{
    private int arr[] = new int[100];
    private int size = 0;

    void insert(int marks){
        size = size + 1;
        int index = size;
        arr[index] = marks;

        while(index > 1){
            int parent = index/2;
            if(arr[parent] < arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else{
                return;
            }
        }
    }
    void print(){
        System.out.println("Printing max heap: ");
        for(int i=1;i<size;i++){
            System.out.println(arr[i] + " ");
        }
    }
}
class MinHeap{
    private int arr[] = new int[100];
    private int size = 0;

    void insert(int marks){
        size = size + 1;
        int index = size;
        arr[index] = marks;

        while(index > 1){
            int parent = index/2;
            if(arr[parent] > arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else{
                return;
            }
        }
    }
    void print(){
        System.out.println("Printing max heap: ");
        for(int i=1;i<size;i++){
            System.out.println(arr[i] + " ");
        }
    }
}

public class heaps {
    void maxHeapify(int arr[], int size, int i){
        int largest = i;
        int left = i*2;
        int right = (i*2)+1;
        if(left <= size && arr[left] > arr[largest]){largest=left;}
        else if(right <= size && arr[right] > arr[largest]){largest=right;}
        if(largest!=i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, size, i);
        }
    }
    void minHeapify(int arr[], int size, int i){
        int smallest = i;
        int left = i*2;
        int right = (i*2)+1;
        if(left <= size && arr[left] < arr[smallest]){smallest=left;}
        else if(right <= size && arr[right] < arr[smallest]){smallest=right;}
        if(smallest!=i){
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            minHeapify(arr, size, i);
        }
    }
    public static void main(String[] args) {
        int size = 0;
        int arr[] = new int[100];

        Scanner scanner = new Scanner(System.in);
        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();

        while(true){
            System.out.println("Enter the marks obtained: ");
            int mark = scanner.nextInt();
            arr[++size] = mark;
            maxHeap.insert(mark);
            minHeap.insert(mark);
            System.out.println("Do you want to insert more? (press 1:yes and 0:No)");
            if(scanner.nextInt()==0) break;
        }
        System.out.println("Getting maximum marks using heapify: ");
        heaps h = new heaps();
        for(int i=size/2;i>0;i--){
            h.maxHeapify(arr, size, i);
        }
        System.out.println("Maximum marks are: " + arr[1]);
        for(int i=size/2;i>0;i--){
            h.minHeapify(arr, size, i);
        }
        System.out.println("Minimum marks are: " + arr[1]);
        scanner.close();
    }    
}
