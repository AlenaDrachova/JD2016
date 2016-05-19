package by.it.luksha.jd01_09;

import by.it.luksha.jd01_09.io.Parser;
import by.it.luksha.jd01_09.operations.Operation;
import by.it.luksha.jd01_09.vars.Matrix;
import by.it.luksha.jd01_09.vars.Scalar;
import by.it.luksha.jd01_09.vars.Var;
import by.it.luksha.jd01_09.vars.Vector;
import static by.it.luksha.jd01_09.operations.Add.*;
import static by.it.luksha.jd01_09.operations.Sub.*;
import static by.it.luksha.jd01_09.operations.Div.*;
import static by.it.luksha.jd01_09.operations.Mult.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Runner {
    public static  void main(String[] args) throws IOException {
        System.out.println("Калькулятор");

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        */
        /*
        String scalar = "-3.14";
        String vector = "{0.0,4.94,-7.03}";
        String matrix = "{{0.57,14.11},{-2.4,0.37}}";
        String string = "-3.14-4.94";

        Var a = Parser.toVar(scalar);
        Var b = Parser.toVar(vector);
        Var c = Parser.toVar(matrix);
        Var[] abc = Parser.toVars(string);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        */

        //скаляры
        Scalar sc1 = new Scalar(2);
        Scalar sc2 = new Scalar(-2);

        //вектора
        double[] array1 = {1, 2, 3, 4, 5, 6};
        double[] array2 = {1, 2, 3, 4, 5, 6};
        double[] array3 = {1, 2, 3};
        Vector vc1 = new Vector(array1);
        Vector vc2 = new Vector(array2);
        Vector vc3 = new Vector(array3);

        //матрицы
        double[][] array4 = {{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}};
        double[][] array5 = {{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}};
        double[][] array6 = {{1, 2, 3},
                             {4, 5, 6}};
        Matrix mx1 = new Matrix(array4);
        Matrix mx2 = new Matrix(array5);
        Matrix mx3 = new Matrix(array6);

        /*
        System.out.println("Сложение скаляра с Var");
        System.out.println("Скаляр+скаляр:");
        System.out.println(add(sc1, sc2));
        System.out.println("Скаляр+вектор:");
        System.out.println(add(sc1, vc1));
        System.out.println("Скаляр+матрица:");
        System.out.println(add(sc2, mx1));

        System.out.println("Сложение вектора с Var");
        System.out.println("Вектор+скаляр:");
        System.out.println(add(vc1, sc1));
        System.out.println("Вектор+вектор:");
        System.out.println(add(vc1, vc2));
        System.out.println("Вектор+вектор:");
        System.out.println(add(vc1, vc3));
        System.out.println("Вектор+матрица:");
        System.out.println(add(vc3, mx2));
        System.out.println("Вектор+матрица:");
        System.out.println(add(vc3, mx3));

        System.out.println("Сложение матрицы с Var");
        System.out.println("Матрица+скаляр:");
        System.out.println(add(mx1, sc1));
        System.out.println("Матрица+вектор:");
        System.out.println(add(mx2, vc3));
        System.out.println("Матрица+вектор:");
        System.out.println(add(mx3, vc3));
        System.out.println("Матрица+матрица:");
        System.out.println(add(mx1, mx2));
        System.out.println("Матрица+матрица:");
        System.out.println(add(mx1, mx3));


        System.out.println("Умножение скаляра с Var");
        System.out.println("Скаляр*скаляр:");
        System.out.println(mult(sc1, sc2));
        System.out.println("Скаляр*вектор:");
        System.out.println(mult(sc1, vc1));
        System.out.println("Скаляр*матрица:");
        System.out.println(mult(sc2, mx1));

        System.out.println("Умножение вектора с Var");
        System.out.println("Вектор*скаляр:");
        System.out.println(mult(vc1, sc1));
        System.out.println("Вектор*вектор:");
        System.out.println(mult(vc1, vc2));
        System.out.println("Вектор*вектор:");
        System.out.println(mult(vc1, vc3));
        System.out.println("Вектор*матрица:");
        System.out.println(mult(vc3, mx2));
        System.out.println("Вектор*матрица:");
        System.out.println(mult(vc3, mx3));

        System.out.println("Умножение матрицы с Var");
        System.out.println("Матрица*скаляр:");
        System.out.println(mult(mx1, sc1));
        System.out.println("Матрица*вектор:");
        System.out.println(mult(mx2, vc3));
        System.out.println("Матрица*вектор:");
        System.out.println(mult(mx3, vc3));
        System.out.println("Матрица*матрица:");
        System.out.println(mult(mx1, mx2));
        System.out.println("Матрица*матрица:");
        System.out.println(mult(mx1, mx3));
        */


        //умножение матрицы и матрицы
        double[][] arrayMatrix3x3 = {{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}};
        double[][] arrayMatrix3x2 = {{1, 2},
                                     {3, 4},
                                     {5, 6}};

        Matrix matrix3x3 = new Matrix(arrayMatrix3x3);
        Matrix matrix3x2 = new Matrix(arrayMatrix3x2);

        System.out.println(mult(matrix3x3, matrix3x2));
    }
}
