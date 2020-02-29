import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeGameTester {

    boolean[][] board1 = {{false, true, false},
            {false, true, false},
            {false, true, false}};
    SnakeGame game1 = new SnakeGame(board1, 1,1);

    boolean[][] board2 = {{true, true, true},
            {false, false, true},
            {true, true, true}};
    SnakeGame game2 = new SnakeGame(board2, 0,0);

    boolean[][] board3 = {{false, false, false, false, false},
            {true, true, true, true, true},
            {true, true, true, true, true},
            {false, false, false, false, false}};
    SnakeGame game3 = new SnakeGame(board3, 3,3);

    boolean[][] board4 = {{false, false}};

    SnakeGame game4 = new SnakeGame(board4, 1,0);

    boolean[][] board5 = {{false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, true, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false}};
    SnakeGame game5 = new SnakeGame(board5, 3,2);



    @Test
    public void testFindTailExhaustive1(){
        int[] expected = new int[]{0, 1, 3};
        int[] actual = game1.findTailExhaustive();

        assertEquals(2, game1.getExhaustiveChecks());
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindTailExhaustive2(){
        int[] expected = new int[]{2, 0, 7};
        int[] actual = game2.findTailExhaustive();

        assertEquals(7, game2.getExhaustiveChecks());
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindTailExhaustive3(){
        int[] expected = new int[]{0, 0, 0};
        int[] actual = game3.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }

    //im trying to see if it works with any board and has  no true values
    @Test
    public void testFindTailExhaustive4(){
        int[] expected = new int[]{0,0,0};
        int[] actual = game4.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }



     // Test case 5: it tests what happens when the head is equal to the tail

    @Test
    public void testFindTailExhaustive5(){
        int[] expected = new int[]{0,0,1};
        int[] actual = game5.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindTailRecursive1(){
        int[] expected = new int[]{1, 1 ,1};
        int[] actual = game1.findTailRecursive();

        assertEquals(1, game1.getRecursiveChecks());
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindTailRecursive2(){
        int[] expected = new int[]{2, 0 ,2};
        int[] actual = game2.findTailRecursive();

        assertEquals(6, game2.getRecursiveChecks());
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindTailRecursive3(){
        int[] expected = new int[]{3, 0 ,9};
        int[] actual = game3.findTailRecursive();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindTailRecursive4(){
        int[] expected = new int[]{0,0,0};
        int[] actual = game4.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindTailRecursive5(){
        int[] expected = new int[]{0,0,1};
        int[] actual = game5.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
}
 //done