package org.ahnu.interfaces;

@FunctionalInterface
public interface AppleFormatter<T> {

    String accept(T a);
}
