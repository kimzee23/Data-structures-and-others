import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestMyArray {
   @Test
       public void testMyArrayConstructor() {
       myArray array = new myArray(5);
       assertEquals(5,array.lenght());

   }
   @Test
    public void testMyArrayFill() {
       myArray array = new myArray(5);
       int [] nums = array.fill(2);
       int [] expected = {2,2,2,2,2};
       assertArrayEquals(expected,nums);
   }

   @Test
   public void testMyArraySearch() {
      myArray array = new myArray(5);
      int [] actual = {1,2,3,4,5};
      int[] expected = {4};
      assertArrayEquals(expected,array.search(actual));
   }
   //   @Test
//   public void testMyArrayArrange() {
//      myArray array = new myArray(5);
//      int [] actual = {5,4,3,2,1};
//      int [] expected = {1,2,3,4,5};
//      actual = array.arrange(actual);
//      assertArrayEquals(expected,actual);
//
//
//   }
}
