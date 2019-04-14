package org.ahnu.interfaces;

import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor<T, R> {

    R process(T t) throws IOException;
}
