import java.util.;
 
public class Advent1 {
  public static void main(String args[]) {
    int dial_pos = 50;
    int dial_change = 0;
    Scanner in = new Scanner(System.in);
    //List<Integer> dials = new ArrayList<Integer>();
    int zero_counter = 0;
    while(in.hasNextLine()){
        //Parsing the input string
        String s = in.nextLine();
        dial_change = parseDialChange(s);
        //creating a history of dial positions
        //dials.add(rotateDial(s.charAt(0),dial_change,dial_pos));
        dial_pos = rotateDial(s.charAt(0),dial_change,dial_pos);
        if(dial_pos == 0){
            zero_counter++;
        }
    }
    ///System.out.println(dials);
    System.out.println(zero_counter);
  }

  public static int rotateDial(char dir, int value, int dial_pos){
      int new_value = value;
      int new_dial_pos = 0;
      if(dir == 'L'){
        new_dial_pos = (dial_pos - new_value % 100 + 100) % 100;
      }
      else{
        new_dial_pos = (dial_pos + new_value) % 100;
      }
      return new_dial_pos;
  }
  public static int parseDialChange(String s){
    int hundreds_place = 0;
    int tens_place = 0;
    int ones_place = 0;
    int dial_change = 0;
    if (s.length()==3){
        ones_place = Integer.parseInt("" + s.charAt(2));
        tens_place = Integer.parseInt("" + s.charAt(1));
        dial_change = tens_place 10 + ones_place;
    }else if (s.length()==4){
        ones_place = Integer.parseInt("" + s.charAt(3));
        tens_place = Integer.parseInt("" + s.charAt(2));
        hundreds_place = Integer.parseInt("" + s.charAt(1));
        dial_change = hundreds_place 100 + tens_place 10 + ones_place;
    }
    else{
        dial_change = Integer.parseInt("" + s.charAt(1));
    }
    return dial_change;
  }
}