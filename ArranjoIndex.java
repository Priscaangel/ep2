public class ArranjoIndex<E> implements ListaIndex<E> {
    protected int capacity;
    public static final int CAPACITY = 8;
    protected E V[];
    protected int size;
  
    public ArranjoIndex(){
      this(CAPACITY);
    }
  
    public ArranjoIndex(int cap){
      capacity = cap;
      V = (E[]) new Object[capacity];
      size = 0;
    }
  
    public int size(){ return size; }
  
    public boolean isEmpty(){ return size == 0; }
  
    public void add(int i, E e) throws IndexOutOfBoundsException {
      if(size == capacity){
        capacity *= 2;
        E[] tmp = (E[]) new Object[capacity];
        for(int j = 0; j < size; j++)
          tmp[j] = V[j];
        V = tmp;
      }
  
      if((i < 0) || (i > size))
        throw new IndexOutOfBoundsException("Indice inválido.");
  
      for(int j = size - 1; j >= i; j--)
          V[j+1] = V[j];
  
      V[i] = e;
      size++;
    }
  
    public E get(int i) throws IndexOutOfBoundsException{
      if((i < 0) || (i > size))
        throw new IndexOutOfBoundsException("Indice inválido.");
      return V[i];
    }
  
    public E remove(int i) throws IndexOutOfBoundsException{
      E tmp = V[i];
      for(int j = i; j < size - 1; j++)
        V[j] = V[j+1];
      size--;
      return tmp;
    }
  
    public E set(int i, E e) throws IndexOutOfBoundsException{
      if((i < 0) || (i > size))
        throw new IndexOutOfBoundsException("Indice inválido.");
      return V[i] = e;
    }
}