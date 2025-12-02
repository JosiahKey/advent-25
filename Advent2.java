import java.util.*;

public class Advent2 {
  public static void main(String args[]) {
    long total = 0;
    //parse input
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    List<String> strList = new ArrayList<String>(Arrays.asList(s.split(",")));
    List<List<Long>> idRanges = new ArrayList<>();

    //get id ranges
    strList.forEach(str -> idRanges.add(findIdRanges(str)));

    for(int i = 0; i<idRanges.size(); i++){
        total += findAndSumInvalidIds(idRanges.get(i));
    }
    System.out.println(""+ total);
  }

  public static List<Long> findIdRanges(String s){
      List<String> resultAsStr = new ArrayList<String>();
      List<Long> result = new ArrayList<Long>();
      resultAsStr = Arrays.asList(s.split("-"));
      result.add(Long.parseLong(resultAsStr.get(0)));
      result.add(Long.parseLong(resultAsStr.get(1)));
      return result;
  }

  public static long findAndSumInvalidIds(List<Long> idRanges){
      long sum = 0;
      long min = idRanges.get(0);
      long max = idRanges.get(1);


      for(long i=min;i<max+1;i++){
          if(checkIfNumInvalid(i)){
              System.out.println(""+ i);
              sum += i;
          }
      }
      return sum;
  }

  public static Boolean checkIfNumInvalid(long x){
      //ignore odd number of digits
      if(String.valueOf(x).length() % 2 == 1){return false;}
      //
      long divisor = 0;
      long x_ponent = String.valueOf(x).length() / 2;

      divisor = (long)Math.pow(10, x_ponent) + 1;
      if(x % divisor == 0){
          return true;
      }
      else{
          return false;
      }
  }
}
/*
You get inside and take the elevator to its only other stop: the gift shop. "Thank you for visiting the North Pole!" gleefully exclaims a nearby sign. You aren't sure who is even allowed to visit the North Pole, but you know you can access the lobby through here, and from there you can access the rest of the North Pole base.

As you make your way through the surprisingly extensive selection, one of the clerks recognizes you and asks for your help.

As it turns out, one of the younger Elves was playing on a gift shop computer and managed to add a whole bunch of invalid product IDs to their gift shop database! Surely, it would be no trouble for you to identify the invalid product IDs for them, right?

They've even checked most of the product ID ranges already; they only have a few product ID ranges (your puzzle input) that you'll need to check. For example:

11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
1698522-1698528,446443-446449,38593856-38593862,565653-565659,
824824821-824824827,2121212118-2121212124

(The ID ranges are wrapped here for legibility; in your input, they appear on a single long line.)

The ranges are separated by commas (,); each range gives its first ID and last ID separated by a dash (-).

Since the young Elf was just doing silly patterns, you can find the invalid IDs by looking for any ID which is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice) would all be invalid IDs.

None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a valid ID that you would ignore.)

Your job is to find all of the invalid IDs that appear in the given ranges. In the above example:

    11-22 has two invalid IDs, 11 and 22.
    95-115 has one invalid ID, 99.
    998-1012 has one invalid ID, 1010.
    1188511880-1188511890 has one invalid ID, 1188511885.
    222220-222224 has one invalid ID, 222222.
    1698522-1698528 contains no invalid IDs.
    446443-446449 has one invalid ID, 446446.
    38593856-38593862 has one invalid ID, 38593859.
    The rest of the ranges contain no invalid IDs.

Adding up all the invalid IDs in this example produces 1227775554.

What do you get if you add up all of the invalid IDs?
*/