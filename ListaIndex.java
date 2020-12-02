public interface ListaIndex <E> {
   
    public int size(); // retorna o tamanho do arranjo

    public boolean isEmpty(); //retorna true se o arranjo estiver vazio

    public void add(int i, E e) throws IndexOutOfBoundsException;  //adiciona um elemento em qualquer posição do arranjo, desde que o índice esteja dentro dos limites do arranjo
    public E get(int i) throws IndexOutOfBoundsException; //retorna o indice solicitado, desde que esse índice esteja dentro dos limites do arranjo
    public E remove(int i) throws IndexOutOfBoundsException; // remove um elemento pelo indice, desde que esse índice esteja dentro dos limites do arranjo
    public E set(int i, E e) throws IndexOutOfBoundsException; 
    
}
