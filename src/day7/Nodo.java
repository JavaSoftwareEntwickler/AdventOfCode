package src.day7;

public abstract class Nodo implements IStreammabile{

    protected Cartella parent;
    protected String nome;

    public abstract long getSize();

    public abstract String getNome();

}