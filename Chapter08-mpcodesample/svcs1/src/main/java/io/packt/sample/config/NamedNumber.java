package io.packt.sample.config;

public class NamedNumber {
    private String name;
    private Number number;

    public NamedNumber(String name, Number number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Number getNumber() {
        return number;
    }
}
