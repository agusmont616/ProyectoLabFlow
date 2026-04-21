package ucu.edu.aed.tda;

import java.util.NoSuchElementException;

import ucu.edu.aed.tda.TDAPila;

public class Pila<T> extends Lista<T> implements TDAPila<T> {
    
    public Pila() {
        super();
    }

    @Override
    public T tope() {
        if (esVacio()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return obtener(tamanio() - 1);
    }

    @Override
    public T saca() {
        if (esVacio()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return remover(tamanio() - 1);
    }

    @Override
    public void mete(T dato) {
        agregar(dato);
    }
}


