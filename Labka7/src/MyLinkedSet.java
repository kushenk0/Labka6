import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyLinkedSet<E> implements Set<E> {
    private Node<E> head;
    private int size;

    @Override
    public boolean contains(Object o) {
        for (Node<E> x = head; x != null; x = x.next) {
            if (x.item.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new Node<>(e);
            size++;
            return true;
        }
        Node<E> x = head;
        while (true) {
            if (x.item.equals(e)) {
                return false;
            }
            if (x.next == null) {
                break;
            }
            x = x.next;
        }
        x.next = new Node<>(e);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.item.equals(o)) {
            head = head.next;
            size--;
            return true;
        }
        Node<E> prev = head;
        while (prev.next != null && !prev.next.item.equals(o)) {
            prev = prev.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean ret = false;
        for (E e : c) {
            ret |= add(e);
        }
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean ret = false;

        while (head != null && !c.contains(head.item)) {
            head = head.next;
            size--;
            ret = true;
        }

        for (Node<E> prev = head; prev != null; prev = prev.next) {
            while (prev.next != null && !c.contains(prev.next.item)) {
                prev.next = prev.next.next;
                size--;
                ret = true;
            }
        }

        return ret;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean ret = false;
        for (Object o : c) {
            ret |= remove(o);
        }
        return ret;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] ret = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            ret[i++] = x.item;
        }
        return ret;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length != size) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            ((Object[]) a)[i++] = x.item;
        }
        return a;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Node<E> x = head; x != null; x = x.next) {
            stringBuilder.append(x.item);
            if (x.next != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private class MyIterator implements Iterator<E> {
        Node<E> next;

        private MyIterator() {
            this.next = head;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E ret = next.item;
            next = next.next;
            return ret;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
        }
    }
}
