
public class Matrix {

    private int[][] arr;

    public Matrix(int n, int m) {
        arr = new int[n][m];
    }

    public int[][] get() {
        return arr;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
