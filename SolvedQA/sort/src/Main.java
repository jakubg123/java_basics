public class Main {
    public static void main(String[] args) throws Exception {

        if(args.length == 0){
            throw new Exception("No parameters included!");
        }

        int[] array = new int[args.length];

        for(int i=0; i < array.length;i++){
            array[i] = Integer.parseInt(args[i]);
        }


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
