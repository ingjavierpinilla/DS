public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public E get(int index) {
        
        if (this.size == 0) {
            return null;
        }
        
        
        
        
        Node<E> node1 = head;

        for (int j = 0; j < index; j++) {

            node1 = node1.after;

        }
        
        return node1.getKey();

    }

    public void pushFront(E key) { // agregar al frente
        Node<E> node1 = new Node<>(null, key, head);
        if (head != null) {
            head.setBefore(node1);
        } else {
            tail = node1;
        }
        head = node1;
        size++;

    }

    public E topFront() {
        if (size == 0) {
            return null;
        }
        return head.getKey();
    }

    public E popFront() {
        if (head==null) {
            return null;
        }
        size--;
        E a= head.getKey();
        head=head.getAfter();
        return a;
    }

    public void pushBack(E key) {
        Node<E> node1 = new Node<>(tail, key, null);
        if (tail == null) {

            tail = head = node1;

        } else {
            tail.setAfter(node1);
            node1.setBefore(tail);
            tail = node1;
        }

        size++;
    }

    public E topBack() {
        if (size == 0) {
            return null;
        }
        return tail.getKey();
    }

    public E popBack() {
        if (tail==null) {
            return null;
        }
        size--;
        E a= tail.getKey();
        tail=tail.getBefore();
        return a;
    }

    public boolean find(E key) {// E x int
        if (size == 0) {
            return false;
        }
        Node<E> node1 = head;
        while (node1.getAfter() != null) {
            if (node1.getKey() == key) {
                return true;
            }
            node1 = node1.getAfter();
        }
        return false;
    }

    public static class Node<E> {

        private Node<E> before;
        private E key;
        private Node<E> after;

        public Node(E key) {
            this.key = key;
        }

        public Node(Node<E> before, E key, Node<E> after) {
            this.before = before;
            this.key = key;
            this.after = after;
        }

        public Node<E> getBefore() {
            return before;
        }

        public void setBefore(Node<E> before) {
            this.before = before;
        }

        public E getKey() {
            return key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public Node<E> getAfter() {
            return after;
        }

        public void setAfter(Node<E> after) {
            this.after = after;
        }
    }
}
