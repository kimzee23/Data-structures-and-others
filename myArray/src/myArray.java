public class myArray {
    private int [] elements;
    private  int [] target ;


    public myArray(int item) {
        this.elements = new int[item];
    }

    public int lenght() {
        return this.elements.length;
    }

    public int[] fill(int item) {
        for (int count = 0; count < elements.length; count++ ) {
            elements[count] = item;
        }
        return elements;
    }

    public int  search(int number) {
        for (int count = 0; count < elements.length; count++ ) {
            if (elements[count] ==number) {
                return elements[count];
            }
        }
        return -1;
    }


//    public int[] arrange(int[] item) {
//        for (int count = 0; count < elements.length -1; count++ ) {
//            for (int counter = 0; counter < elements.length -1; counter++) {
//                if (elements[counter] > elements[counter+1]) {
//                    int temp = elements[counter];
//                    elements[counter] = elements[counter+1];
//                    elements[counter+1] = temp;
//                }
//            }
//        }
//        return elements;
//    }
}