package ucu.edu.aed.tda;

public class Conjunto<T> extends Lista<T> implements TDAConjunto<T> {

    public Conjunto() {
        super();
    }
    
    @Override
    public void agregar(T elem) {
        if (!contiene(elem)) { // Verifica si el elemento ya está presente en el conjunto
            super.agregar(elem); // Si no está presente, se agrega utilizando el método de la clase padre (Lista)
        }

    }

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>(); // Se crea un nuevo conjunto para almacenar el resultado de la unión
        for (int i = 0; i < tamanio(); i++){ // Se agregan todos los elementos del conjunto actual
            resultado.agregar(obtener(i));
        }

        for (int i = 0; i < otro.tamanio(); i++){ // Se agregan los elementos del otro conjunto, verificando que no se dupliquen
            T elem = otro.obtener(i);
            if (!resultado.contiene(elem)){
                resultado.agregar(elem);
            }
        }
        return resultado;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>(); // Conjunto resultado
        for (int i = 0; i < tamanio(); i++) { // Se recorren los elementos del conjunto actual
            T elem = obtener(i);
            if (otro.contiene(elem)) { // Si el elemento está en el otro conjunto
                resultado.agregar(elem); // Se agrega al conjunto resultado
            }
        }
        return resultado;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
    Conjunto<T> resultado = new Conjunto<>(); // Conjunto resultado
        for (int i = 0; i < tamanio(); i++) { // Se recorren los elementos del conjunto actual
            T elem = obtener(i);
            if (!otro.contiene(elem)) { // Si el elemento no está en el otro conjunto
                resultado.agregar(elem); // Se agrega al conjunto resultado
            }
        }
        return resultado;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        for (int i = 0; i < tamanio(); i++) {
            T elem = obtener(i);
            if (!otro.contiene(elem)) {
                return false; // Si encuentra un elemento que no está en el otro conjunto, no es subconjunto
            }
        }
        return true;
    }

}
