package by.it.luksha.jd01_06;

public class Runner {
    public static void main(String[] args) {
        //TaskA
        TaskA.task1();
        TaskA.task2();
        TaskA.task3();

        //TaskB
        TaskB.task1();
        TaskB.task2();
        TaskB.task3("о");

        //TaskC
        TaskC.formatEdgewise();
        System.out.println("Выигрыш в пользу StringBuilder " + ((TaskC.createPoemByConcat() - TaskC.createPoemByAppend())*1000) + " микросекунд");
        TaskC.sort();

    }
}
