public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks = 0;
    private static int recursiveChecks = 0;
    public int[] x;
    public int[] y;
    int Length;
    int result;
public static void main(String[] args){}
    public SnakeGame(){
        game = new boolean [1][1];
        game[0][0] = true;
    }

    public SnakeGame(boolean[][] arr, int x, int y) {
        this.game  = new boolean[arr.length][arr[0].length];
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length;j++){
                this.game[i][j] = arr[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;

    }

    public int[] findTailExhaustive() {
        resetCounters();
        int[] tail = new int[3];
        tail[2] = length();

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                if(game[i][j]){
                    if((headPosition[0] != i || headPosition[1] != j) && neighbors(i,j) == 1){
                        tail[0] = i;
                        tail[1] = j;
                        return tail;
                    }
                }
            }
        }

        //tail[2] = length;

        return tail;

    }


    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);

    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks++;
        int row = currentPosition[0];
        int col  = currentPosition[1];
        int[] temp = new int[2];
        if(row - 1 >= 0){//bounds
            if(game[row - 1][col] == true) {//has neighbor
                if(row - 1 != previousPosition[0] || col != previousPosition[1]){
                    Length++;
                    temp[0] = row - 1;
                    temp[1] = col;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if(col - 1 >= 0){//bounds
            if(game[row][col - 1] == true) {//has neighbor
                if(row != previousPosition[0] || col - 1 != previousPosition[1]){
                    Length++;
                    temp[0] = row;
                    temp[1] = col - 1;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }

        if(col + 1 < game.length){//bounds
            if(game[row][col + 1] == true) {//has neighbor
                if(row != previousPosition[0] || col + 1 != previousPosition[1]){
                    Length++;
                    temp[0] = row;
                    temp[1] = col + 1;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if(col - 1 >= 0){//bounds
            if(game[row][col - 1] == true) {//has neighbor
                if(row != previousPosition[0] || col - 1 != previousPosition[1]){
                    Length++;
                    temp[0] = row;
                    temp[1] = col - 1;
                    previousPosition = currentPosition;
                    currentPosition = temp;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        Length++;
        System.out.println(row + " " + col + " " + Length);
        return new int[]{row, col, Length};
    }

//fixed

public int[] neighborRecursive(int r, int c, int[] previous){
        int newPosition[] = new int[2];

    if((c - 1 > -1 && game[r][c - 1]) && (previous[1] != c - 1)){

        newPosition[0] = r;
        newPosition[1] = c - 1;
    }//left
    else if((c + 1 < game[r].length && game[r][c + 1]) && (previous[1] != c + 1)){
        newPosition[0] = r;
        newPosition[1] = c + 1;
    }//right

       else if((r - 1> -1 && game[r - 1][c]) && (previous[0] != r - 1)){

        newPosition[0] = r - 1;
        newPosition[1] = c;
        }//up

        else if((r + 1 < game.length && game[r + 1][c]) && (previous[0] != r + 1)){

        newPosition[0] = r + 1;
        newPosition[1] = c;
        }//down



        return newPosition;
        }
        public int neighbors(int r, int c){
         int sum = 0;
          if(c - 1 > -1 && game[r][c - 1]){
              sum++;
        }//left
          if(c + 1 < game[r].length && game[r][c + 1]){
              sum++;
        }//right
          if(r - 1> -1 && game[r - 1][c]){
              sum++;
            }//up
            if(r + 1 < game.length && game[r + 1][c]){
                sum++;
            }//downn
       return sum;
        }
    public int length(){
        int count = 0;

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                if(game[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
    public void resetCounters(){
       recursiveChecks=0;
       exhaustiveChecks=0;
    }
    public static int getRecursiveChecks(){
     return recursiveChecks;
    }
    public static int getExhaustiveChecks(){
     return exhaustiveChecks;
    }

}
//Finished
