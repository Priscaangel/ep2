interface Pilha<E> {
   
    public int size(); //devolve o tamanho da pilha
  

    public boolean isEmpty(); //verifica se a pilha está vazia
  

    public E top() throws EmptyStackException; //devolve o elemento no topo da pilha
  
 
    public void push(E element); //insere um elemento no topo da pilha
  

    public E pop() throws EmptyStackException; //remove e devolve o elemento no topo da pilha
  }
  