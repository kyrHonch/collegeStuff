import java.util.*;
class SortedList<E extends Comparable<? super E>> extends List<E> {
    public void insert(E data) {
        Node <E> temp = new Node<E>(data);
        this.insert(head, temp);
    }
    //Recursive insert 1
    private void insert(Node <E> curr, Node<E> temp){
        if(curr == null || temp.data.compareTo(curr.data) < 0){
            temp.next = curr;
            head = temp;
        }else if(curr.next != null && temp.data.compareTo(curr.next.data) >= 0){
            insert(curr.next, temp);
        }else{
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    //Iterator 2
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            private Node<E> curr = head;
        };
    }
    public void remove(E data) {
        if(head.data.compareTo(data) == 0){
            head = head.next;
            return;
        }
        Node <E> temp = head;
        remove(temp, data);
        head = temp;
    }
    //Recursive remove 3
    private void remove(Node <E> curr, E data){
        if(curr != null && curr.next != null){
            if(data.compareTo(curr.next.data) == 0) {
                curr.next = curr.next.next;
                return;
            }
            remove(curr.next, data);
        }
    }

    public E retrieve(int index) {
        return retrieve(head, index);
    }

    //Recursive retrieve 4
    private E retrieve(Node <E> curr, int index){
        if (index == 0) {
            return curr.data;
        }else if(curr.next != null && index > 0){
            return retrieve(curr.next, --index);
        }
        return null;
    }
    @Override
    //Recursive search 5
    public boolean search(E data){
        return search(head, data);
    }
    private boolean search(Node <E> curr, E data){
        if(data.compareTo(curr.data) == 0){
            return true;
        }else if(curr.next != null) {
            return search(curr.next, data);
        }
        return false;
    }
}
