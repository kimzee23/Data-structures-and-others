public class MyStack {
//    public boolean size;
    private int  [] elements;
    private int count;

    public MyStack(int size) {
        elements = new int[size];
        count = 0;

    }


    public boolean is_empty() {

        return count == 0;
    }

    public int push(int items) {
        elements[count++] = items;

        return count;
    }


    public int pop(int item) {
        return  elements[--count]=item;

    }

    public int peek(int item) {
        return elements[count-1]=item;

    }

    public int search(int item) {
            for (int counter = count - 1; counter >= 0; counter--) {
                if (elements[counter] == item) {
                    return count - counter;
                }
            }
            return -1;
        }

    public int multipleOfTwo(int item) {
        for (int counter = 0; counter <= elements.length -1; counter++) {
            if (elements[counter] % 2 == item) {
                return counter;

            }
        }
        return count;
    }


    public void clear() {
        elements = new int[elements.length];
        count = 0;
    }

    public int size( ) {
       return count;
    }
}

