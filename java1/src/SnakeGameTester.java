import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SnakeGameTester {
    boolean[][] board1 = {{false, false, false},
            {false, true, false},
            {false, true, false}};
    SnakeGame game1 = new SnakeGame(board1, 1, 2);

    boolean[][] board2 = {{false, false, false},
            {false, false, false},
            {false, false, false}};
    SnakeGame game2 = new SnakeGame(board2, 2, 2);

    boolean[][] board3 = {{true, true, true},
            {true, true, true},
            {true, true, true}};
    SnakeGame game3 = new SnakeGame(board3, 1, 1);

    boolean[][] board4 = {{true, false, true},
            {true,false, true},
            {true, false, true}};
    SnakeGame game4 = new SnakeGame(board4, 1, 1);

    boolean[][] board5 = {{false, true, false},
            {false, true, false},
            {false, true, false}};
    SnakeGame game5 = new SnakeGame(board5, 1, 1);




    @Test
    public void testFindTailExhaustive() {
        int[] expected = new int[]{2, 1, 2};
        int[] actual = game1.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindTailExhaustive1() {
        int[] expected = new int[]{2, 2, 1};
        int[] actual = game2.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindTailExhaustive2() {
        int[] expected = new int[]{0, 2, 3};
        int[] actual = game3.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindTailExhaustive3() {
        int[] expected = new int[]{0, 0, 3};
        int[] actual = game4.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindTailExhaustive4() {
        int[] expected = new int[]{0, 2, 3};
        int[] actual = game5.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindrecursive() {
        int[] expected = new int[]{1, 1, 2};
        int[] actual = game1.findTailRecursive();

        assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindrecursive1() {
        int[] expected = new int[]{2, 2, 1};
        int[] actual = game2.findTailRecursive();

        assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindrecursive2() {
        int[] expected = new int[]{0, 0, 3};
        int[] actual = game3.findTailRecursive();

        assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindrecursive3() {
        int[] expected = new int[]{0, 0, 3};
        int[] actual = game4.findTailRecursive();

        assertArrayEquals(expected, actual);

    }
    @Test
    public void testFindrecursive4() {
        int[] expected = new int[]{0, 1, 2};
        int[] actual = game5.findTailRecursive();

        assertArrayEquals(expected, actual);

    }


}

