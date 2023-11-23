import java.util.Iterator;
import java.util.Vector;
public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    private Node<E> findIOP(Node<E> curr) {
        curr = curr.left;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> curr) {
        if (curr == null) {
            return 0;
        }
        int left = height(curr.left) + 1;
        int right = height(curr.right) + 1;
        return left > right ? left : right;
    }
    public void insert(E data){

        Node<E> temp = new Node <E> (data);
        Node<E> curr = root;
        root = insert(temp,curr);

    }

    private Node<E> insert(Node<E> temp, Node<E> curr){

        if(curr == null){

            curr = temp;
            return curr;

        }

        else if (temp.data.compareTo(curr.data) <=0){


            curr.left = insert(temp, curr.left);
            return curr;

        }
        else{


            curr.right = insert(temp, curr.right);
            return curr;
        }
    }


    public Iterator<E> iterator() {
        vector = new Vector<E>();
        traverse(root);
        return vector.iterator();
    }
    public void remove(E data) {
        if (root != null && data!= null && search(data)) {
            root = remove(root, data);
        }
    }

    private Node<E> remove(Node<E> curr, E data) {


        if (data.compareTo(curr.data) < 0) {
            curr.left = remove(curr.left, data);
        } else if (data.compareTo(curr.data) > 0) {
            curr.right = remove(curr.right, data);
        } else {
            if (curr.left == null && curr.right == null) {
                curr = null;
            } else if (curr.left == null) {
                curr = curr.right;
            } else if (curr.right == null) {
                curr = curr.left;
            } else {
                Node<E> iop = findIOP(curr);
                curr.data = iop.data;
                curr.left = remove(curr.left, iop.data);
            }
        }

        return curr;
    }




    public boolean search(E data){

        Node<E>  curr = root;
        return search(curr, data);

    }

    private boolean search(Node<E> node, E data){
        if(node == null){
            return false;
        }

        if(data.compareTo(node.data) == 0){
            return true;
        }
        else if(data.compareTo(node.data)<0){
            return search(node.left,data);
        }
        else {
            return search(node.right, data);
        }

    }



    private void traverse(Node<E> curr) {
        if (curr != null) {
            traverse(curr.left);
            vector.add(curr.data);
            traverse(curr.right);
        }
    }

    private Vector<E> vector;


}
