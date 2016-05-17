package by.it.luksha.jd01_08.hospital.staff;

import by.it.luksha.jd01_08.hospital.patient.Patient;
import java.util.Random;

public class Neurosurgeon extends Surgeon {
    //специализация хирурга
    private String specialization;

    /**
     * Конструктор класса нейрохирург
     * @param name           имя хирурга
     * @param skill          навык хирурга
     */
    public Neurosurgeon(String name, int skill) {
        super(name, skill);
        this.specialization = "нейрохирург";
    }

    /**
     * Метод операции для пациента
     * @param patient пациент
     * @return исход, true - положительный
     */
    @Override
    public boolean carryOutOperation(Patient patient) {
        System.out.println("Операция началась...");
        double correlation = new Random().nextDouble();
        if (correlation <= this.chanceGoodOperation()) {
            return true;
        }
        else
            return false;
    }

    /**
     * Динамический полиморфизм
     */
    @Override
    public String toString() {
        return super.toString() + " Моя специализация - " + specialization + ".";
    }
}
