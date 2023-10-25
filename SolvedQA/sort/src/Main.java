public class Main {
    public static void main(String[] args) {

        if(args.length > 0){
            System.out.println(args[0]);
        }
        int [] array = {1,2,3,9,8,7,5,2};

        quickSort(array, 0 , array.length - 1);
        printArray(array);



    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];

        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void printArray(int[] array){
        for(int number : array){
            System.out.println(number);
        }
    }


}
