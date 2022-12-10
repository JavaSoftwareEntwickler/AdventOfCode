package scr.day7;

import java.util.stream.Stream;

public class File extends Nodo {

    private final Cartella cartella = new Cartella();
    protected Long dimensioneFile;

    public long getSize() {
        return dimensioneFile;
    }

    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public <T> Stream<T> streamContenuti() {
        return (Stream<T>) cartella.streamContenuti();
    }
}
