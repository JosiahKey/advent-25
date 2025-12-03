import java.util.*;

public class Advent3 {
  public static void main(String args[]) {
    long totalOutputJoltage = 0;
    //parse input battery banks to string array
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    String[] batteryJoltagesString = new String[100];
    //batteryJoltagesString = s.split("");
    int[] batteryJoltages = new int[100];
    //batteryJoltages[i] = Integer.valueOf(batteryJoltagesString[i]);
    
    while(in.hasNextLine()){
        batteryJoltagesString = s.split("");
        //convert string array into int array
        for(int i = 0; i<s.length(); i++){
            batteryJoltages[i] = Integer.valueOf(batteryJoltagesString[i]);
        }
        totalOutputJoltage += findMaxJoltage(batteryJoltages, s);
        System.out.println(findMaxJoltage(batteryJoltages, s) + " running total: " + totalOutputJoltage);
        s = in.nextLine();
    }
    
    //and one more time for the last line
    batteryJoltagesString = s.split("");
    for(int i = 0; i<s.length(); i++){
        batteryJoltages[i] = Integer.valueOf(batteryJoltagesString[i]);
    }
    totalOutputJoltage += findMaxJoltage(batteryJoltages, s);
    System.out.println(findMaxJoltage(batteryJoltages, s) + " running total: " + totalOutputJoltage);
  }
  
  public static int findMaxJoltage(int[] batteryJoltages, String s){
    int maxJolts = 0;
    
    //biggest number should always be the tens place, so scan for largest number
    //except that the tens place should never be the last digit
    int tens = 0;
    int indexOfTens = 0;
    for(int i = 0; i<s.length()-1; i++){
        if(batteryJoltages[i] > tens){
            tens = batteryJoltages[i];
            indexOfTens = i;
        }
    }
    
    //then find the largest number to the right side of the tens place
    int ones = 0;
    for(int i = indexOfTens+1; i<s.length(); i++){
        if(batteryJoltages[i] > ones){
            ones = batteryJoltages[i];
        }
    }
    
    //format for return value
    String tempString = tens + "" + ones;
    maxJolts = Integer.valueOf(tempString);
    return maxJolts;
  }
}
/*
 * There are batteries nearby that can supply emergency power to the escalator
 * for just such an occasion.
 * The batteries are each labeled with their joltage rating, a value from 1 to
 * 9. You make a note of their joltage ratings (your puzzle input). For example:
 * 
 * 987654321111111
 * 811111111111119
 * 234234234234278
 * 818181911112111
 * 
 * The batteries are arranged into banks; each line of digits in your input
 * corresponds to a single bank of batteries.
 * Within each bank, you need to turn on exactly two batteries; the joltage that
 * the bank produces is equal to the number formed by
 * the digits on the batteries you've turned on. For example, if you have a bank
 * like 12345 and you turn on batteries 2 and 4, the bank would produce 24
 * jolts. (You cannot rearrange batteries.)
 * 
 * You'll need to find the largest possible joltage each bank can produce. In
 * the above example:
 * 
 * In 987654321111111, you can make the largest joltage possible, 98, by turning
 * on the first two batteries.
 * In 811111111111119, you can make the largest joltage possible by turning on
 * the batteries labeled 8 and 9, producing 89 jolts.
 * In 234234234234278, you can make 78 by turning on the last two batteries
 * (marked 7 and 8).
 * In 818181911112111, the largest joltage you can produce is 92.
 * 
 * The total output joltage is the sum of the maximum joltage from each bank, so
 * in this example, the total output joltage is 98 + 89 + 78 + 92 = 357.
 * 
 * There are many batteries in front of you. Find the maximum joltage possible
 * from each bank; what is the total output joltage?
 */
