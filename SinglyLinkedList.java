package list;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public String toString() {
        return "SinglyLinkedList{" + "head=" + head + ", tail=" + tail + ", size=" + size + '}';
    }

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

    public void pushFront(E key) {
        Node<E> node1 = new Node<>(key, head);
        if (tail == null) {
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
        if (head == null) {
            return null;
        }
        size--;
        E a = head.getKey();
        head = head.getAfter();
        return a;
    }

    public void pushBack(E key) {
        Node<E> node1 = new Node<>(key, null);
        if (tail == null) {

            tail = head = node1;

        } else {
            tail.setAfter(node1);
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
        Node<E> node1 = head;
        if (head == null) {
            return null;
        }
        if (head == tail) {
            E a = tail.getKey();
            size--;
            head = tail = null;
            return a;
        } else {

            while (node1.getAfter().getAfter() != null) {
                node1 = node1.getAfter();
            }

        }
        node1.setAfter(null);
        size--;
        E a = tail.getKey();
        tail = node1;
        return a;

    }

    public boolean find(E key) {
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

        private E key;
        private Node<E> after;

        public Node(E key) {
            this.key = key;
        }

        public Node(E key, Node<E> after) {
            this.key = key;
            this.after = after;
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

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", after=" + after + '}';
        }

    }
}
