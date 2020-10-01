package first;

public class HelloJava {

    public static void main(String[] args) {

        Matrix A, B, C, D, E, F;

        A = new Matrix(3, 3);
        B = new Matrix(new int[][]{{1, 2, 1}, {2, 1, 2}, {1, 2, 1}});
        C = new Matrix(3, 3, 2);

        System.out.println("\nMatrix A");
        A.print();
        System.out.println("\nMatrix B");
        B.print();
        System.out.println("\nMatrix C");
        C.print();
        D = B.sumMatrix(C);
        System.out.println("\nMatrix B + C");
        D.print();



    }

}
