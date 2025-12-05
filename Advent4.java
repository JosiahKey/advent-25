import java.util.*;

public class Advent4{
  public static void main(String args[]) {
    //parse inputs into a grid of array list
    //could easily just do 2d array, but i don't feel like it.
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    ArrayList<String> gridRow = new ArrayList<String>();
    int rowSize = s.split("").length -1;
    
    while(in.hasNextLine()){
        String[] ugh = s.split("");
        gridRow.addAll(Arrays.asList(ugh));
        grid.add(new ArrayList<String>(gridRow));
        gridRow.clear();
        s = in.nextLine();
        if(!in.hasNextLine()){//last line
            ugh = s.split("");
            gridRow.addAll(Arrays.asList(ugh));
            grid.add(new ArrayList<String>(gridRow));
            gridRow.clear();
        }
    }
    //System.out.println(grid);
    
    
    //loop through each element and check if a roll is valid
    for(int i = 0; i< grid.size(); i++){
        for(int j = 0; j<rowSize; j++){
            if(isRoll(grid,i,j)){
                if(isForkliftable(grid,i,j,rowSize)){
                    //System.out.println(i+ ", "+j);
                }
            }
        }
    }
  }
  
  public static boolean isRoll(ArrayList<ArrayList<String>> grid, int y, int x){
        if(grid.get(y).get(x).equals("@")){
            return true;
        }
        else{return false;}
  }
  
  public static boolean isForkliftable(ArrayList<ArrayList<String>> grid, int y, int x, int lastIndex){
      System.out.println(y+ ", "+x);
        if(y == 0){//first row special
            return false;
        }
        else if (y == grid.size()-1){//last row special
            return false;
        }else{//middle rows default
            System.out.println("being checked");
            int adjacentRolls = 0;
            for(int i = y-1;i <= y+1;i++){//each row of adjacent coords
                if(x-1 >=0){//left side
                    if(isRoll(grid, i, x-1)){
                        adjacentRolls++;
                    }
                }
                if(x+1 < lastIndex){//right side
                    if(isRoll(grid, i, x+1)){
                        adjacentRolls++;
                    }
                }
                if(isRoll(grid, i, x)){
                    adjacentRolls++;
                }
            }
            return true;
        }
  }
}