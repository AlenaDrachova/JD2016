package by.it.novik.jd02_06.matlab.operations;

import by.it.novik.jd02_06.matlab.entity.Variable;

/**
 * Created by Kate Novik.
 */
public interface IEquality {
    /**
     * Операция равенства Equality
     * @param value Значение переменной
     * @param nameVar Название переменной
     * @return true - имени переменной присвоено значение
     */
    boolean equality(String nameVar, Variable value);
}
