public class OddOrPos {
    public static void main(String[] args) {
        int[] x = {-3, -2, 0, 1, 4};
        assert oddOrPos(x) == 3 : "Test failed"; // Expected = 3
    }

    /**
     * Count odd or positive elements
     *
     * @param x array to search
     * @return count of odd/positive values in x
     * @throws NullPointerException if x is null
     */
    public static int oddOrPos(int[] x) {
        int count = 0;
		for (int i : x) {
			if (i % 2 != 0 || i > 0) {
				count++;
			}
		}
        return count;
    }
}
