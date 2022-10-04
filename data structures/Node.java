public class Node<T>
{
    private T val;
    private Node<T> next, prev;

    public Node(T tVal){
        val = tVal;
    }

    public void setNext(Node<T> n) { next=n;}
    public void setPrev(Node<T> p) { prev=p;}

    public Node<T> getNext() { return next; }
    public Node<T> getPrev() { return prev; }
    public T getVal() { return val; }
    public static void main(String... args) {
        Node<Integer> node = new Node<>(10);
        node.setNext(node);
        node.setPrev(node);
    }
}