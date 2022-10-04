
public class LinkedList<T>{
    private Node<T> root, tail;
    int nElements = 0;
    
    public LinkedList<T> add(T val) {
       return add(val, nElements)
    }

    public LinkedList<T> add(T val, index) {
        Node<T> node = new Node<>(val);
        if(tail == null) {  root = node;       }
        else {  tail.setNext(node);   }
        tail = node;
        nElements++;
        return this;
    }

    private Node<T> getNodeAt(int index){
        Node<T> current = root;
        while (index > 0)
        {
            current = current.getNext();
            index--;
        }
        return current;
    }

    public T delete(){
        return delete(nElements-1);
    }

    public T delete(int index){

    }

    public T get(int index){
        getNodeAt(index).getVal();
    }

    public int size() {return nElements;}

    public static void main(String ... args){
        LinkedList<Integer> list = new LinkedList<>();
        list.append(20).add(22);
        System.out.println(list.size());
    }
}