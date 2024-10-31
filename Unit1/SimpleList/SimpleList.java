package SimpleList;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings({"rawtypes", "unused"})
public class SimpleList implements List {
    private SimpleNode head;
    private int size;
    /**
     * SimpleNode definition of a single-linked list of Objects 
     */
    private class SimpleNode {
        private Object _data;
        private SimpleNode _next;
        
        private SimpleNode(Object data) {
            this(data,  null);
        }
        
        private SimpleNode(Object data, SimpleNode next) {
            _data = data;
            _next = next;
        }
    }
    
    /**
     * TODO: Class fields: Keep track of the head and tail of the list
     * TODO: and the number of nodes it contains.
     */
    public SimpleList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param element - element to be appended to this list.
     * @return true
     */
    @Override
    public boolean add(Object element) {
        SimpleNode cur = head;
        if(cur == null) {
            head = new SimpleNode(element);
        }
        else {
            while(cur._next != null) {
                cur = cur._next;
            }
            cur._next = new SimpleNode(element);
        }
        size++;
        return true;
    }
    
    /**
     * Inserts the specified element at the specified position in this list.
     * @param index - index at which the specified element is to be inserted.
     * @param element - element to be inserted.
     */
    @Override
    public void add(int index, Object element) {
        if(head == null) {
            add(element);
        }
        else if(index == 0) {
            head = new SimpleNode(element, head);
            size++;
        }
        else {
            SimpleNode cur = head;
            for(int i = 0; i < index - 1; i++) {
                cur = cur._next;
            }
            SimpleNode node = new SimpleNode(element, cur._next);
            cur._next = node;
            size++;
        }
    }
    
    /**
     * Removes all of the elements from this list (optional operation).
     */
    @Override
    public void clear() {
        this.head = null;
        size = 0;
    }
    
    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return.
     * @return the element at the specified position in this list.
     */
    @Override
    public Object get(int index) {
        SimpleNode cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur._next;
        }
        return cur._data;
    }
    
    /**
     * Removes the element at the specified position in this list.
     * @param index - the index of the element to be removed.
     * @return the element previously at the specified position.
     */
    @Override
    public Object remove(int index) {
        SimpleNode removed;
        if(index == 0) {
            removed = head;
            head = head._next;
            size--;
            return removed._data;
        }
        SimpleNode cur = head;
        for(int i = 0; i < index - 1; i++) {
            cur = cur._next;
        }
        removed = cur._next;
        cur._next = cur._next._next;
        size--;
        return removed._data;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index - index of the element to replace.
     * @param element - element to be stored at the specified position.
     * @return the element previously at the specified position.
     */
    @Override
    public Object set(int index, Object element) {
        SimpleNode cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur._next;
        }
        Object data = cur._data;
        cur._data = element;
        return data;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // #region: Overrides not supported by the SimpleList
    @Override
    public boolean contains(Object o) {
        SimpleNode cur = head;
        while(cur != null) {
            if(cur._data.equals(o)) {
                return true;
            }
            cur = cur._next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        SimpleNode cur = head;
        for(int i = 0; i < size; i++) {
            arr[i] = cur._data;
            cur = cur._next;
        }
        return arr;
    }

    @Override
    public Object[] toArray(Object[] a) {
        SimpleNode cur = head;
        for(int i = 0; i < a.length; i++) {
            if(cur == null) {
                a[i] = null;
            }
            else {
                a[i] = cur._data;
                cur = cur._next;
            }
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        SimpleNode cur = head;
        while(cur._next != null) {
            if(cur._next._data.equals(o)) {
                cur._next = cur._next._next;
                size--;
                return true;
            }
            cur = cur._next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iterator = c.iterator();
        while(iterator.hasNext()) {
            Object element = iterator.next();
            if(!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean changed = false;
        Iterator iterator = c.iterator();
        while(iterator.hasNext()) {
            Object element = iterator.next();
            add(element);
            changed = true;
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    // #endregion: Overrides not supported by the SimpleList
}
