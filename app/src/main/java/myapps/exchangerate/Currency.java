package myapps.exchangerate;

/**
 * Класс, описывающий каждую валюту,
 * и предоставляющий методы для назначения и считывания значений полей
 */

public class Currency {
    private String charCode;
    private String name;
    private String nominal;
    private String value;

    public Currency() {
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}