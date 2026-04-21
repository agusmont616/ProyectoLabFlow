package ucu.edu.aed.tda;

public class Cola<T> extends Lista<T> implements TDACola<T>{

    public Cola() {
        super();
    }

    @Override
    public T frente() {
        if (esVacio()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        return obtener(0);
    }

    @Override
    public boolean poneEnCola(T dato) {
        agregar(dato);
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (esVacio()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        return remover(0);
    }
    
}
