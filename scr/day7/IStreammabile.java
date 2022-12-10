package scr.day7;

import java.util.stream.Stream;

public interface IStreammabile {
    public <T> Stream<T> streamContenuti();
}
