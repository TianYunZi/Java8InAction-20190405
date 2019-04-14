package org.ahnu.model;

import java.math.BigDecimal;

public class Apple {

    private String color;

    private BigDecimal heavy;

    public Apple(String color, BigDecimal heavy) {
        this.color = color;
        this.heavy = heavy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getHeavy() {
        return heavy;
    }

    public void setHeavy(BigDecimal heavy) {
        this.heavy = heavy;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getHeavy().compareTo(new BigDecimal(140)) > 0;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", heavy=" + heavy +
                '}';
    }
}
