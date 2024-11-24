import java.util.Random;
import java.util.stream.IntStream;

public class StreamUtil
{
   /**
    * Measures the time it takes to count the number of odd numbers using
    * an infinite stream, given a limit. 
    * @param generator the Random generator used to generate the numbers.
    * @param limit the number of odd numbers to count
    * @param isParallel if true, use a parallel stream
    */
   public static long timeOdds(Random generator, int limit, boolean isParallel)
   {
      long result = 0;
      
      long startTime = System.nanoTime();

      //Creates stream of random values from Integer.MIN_VALUE and Integer.MAX_VALUE   
      IntStream oddStream = generator.ints(Integer.MIN_VALUE, Integer.MAX_VALUE);
      if (isParallel) { oddStream.parallel();} //Checks to see if stream will be run as parallel.

      //Make sure stream only has odd numbers in it.
      long count = oddStream
         .filter(w -> w % 2 != 0)
         .limit(limit)
         .count();
         
      long endTime = System.nanoTime();

      //Calculate elapsed time.
      result = endTime - startTime;
         
         
         
         
         
      return result;
   }
}