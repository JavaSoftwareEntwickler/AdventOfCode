package scr.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cartella extends Nodo {
    protected final List<Nodo> contenuti = new ArrayList<>();

    protected Collection<Cartella> getSubCartelle() {
        return contenuti.stream().filter(Cartella.class::isInstance)
                .map(Cartella.class::cast).collect(Collectors.toList());
    }
    @Override
    public Stream<Cartella> streamContenuti(){
        return Stream.concat(
                Stream.of(this), contenuti.stream().flatMap(Nodo::streamContenuti));
    }
    @Override
    public long getSize() {
        return contenuti.stream().mapToLong(Nodo::getSize).sum();
    }

    @Override
    public String getNome() {
        return nome;
    }


}