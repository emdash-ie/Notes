// have to import Iterator
import java.util.Iterator;

/**
 * A linked list implementation.
 */
public class List<T> implements Iterable<T> {
    /**
     * The first link in the list.
     */
    private Link<T> link;
    /**
     * Creates an empty list (by setting the first link to null).
     */
    public List() {
        link = null;
    }
    /**
     * Adds a new value to the front of the list.
     */
    public void add(final T value) {
        link = new Link<T>(link, value);
    }
    /** Since it implements Iterator, we no longer need to delegate.
     * Instead we can just cycle through.
     */
    public void print() {
        String separator = "";
        for (T element : this) {
            System.out.print(separator + element);
            separator = " ";
        }
    }

    /** Delegates as above. */
    public void append(final List<T> that) {
        this.link = Link.append(this.link, that.link);
    }

    /** Have to override this to provide an object that implements the
     * Iterator interface
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // Need instance attributes to keep track of the current link
            // When the instance of the iterator class is constructed, this
            // is set to the first link.
            Link<T> current = link;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                final T result = current.head;
                current = current.tail;
                return result;
            }
            // Overriding remove isn't possible with this implementation
            // of our iterator.
        };
    }


    /** Delegates task of sorting to a class method in the Link class. */
    public static <T extends Comparable<T>> void sort(final List<T> list) {
        list.link = Link.sort(list.link);
    }

    private static class Link<T> {
        /** The value contained in the current link. */
        private T head;
        /**
         * The next link in the list – null if this is the last link.
         */
        private Link<T> tail;

        private static <T extends Comparable<T>> Link<T> sort(final Link<T> list) {
            final Link<T> result;
            if ((list == null) || (list.tail == null)) {
                result = list;
            } else {
                final Link<T> pivot = list;
                final Partition<T> partition = Partition.partition(pivot.head, list.tail);
                pivot.tail = sort(partition.gt);
                result =  append(sort(partition.leq), pivot);
            }
            return result;
        }

        /**
         * Creates a new Link whose tail link is the passed link and whose
         * value is the passed value.
         */
        private Link(final Link<T> link, final T value) {
            this.head = value;
            this.tail = link;
        }

        private static <T> Link<T> add(final Link<T> link, final T value) {
            return link;
        }

        /**
         * Appends the contents of list2 to the beginning of list1.
         *
         * Note we aim to have only one exit from our function, because
         * he claims it makes it easier to reason about our functions.
         *
         * Have to provide a context for T, because the static methods won't
         * have been passed a type.
         */
        private static <T> Link<T> append(final Link<T> list1, final Link<T> list2) {
            final Link<T> result;

            if (list1 == null) {
                result = list2;
            } else {
                result = list1;
                list1.tail = append(list1.tail, list2);
            }
            return result;
        }
    }
    /**
     * Represents a partition of a list used for quicksort – a pivot, the
     * numbers greater than the pivot, and the numbers less than or equal
     * to the number.
     */
    private static class Partition<T extends Comparable<T>> {
        private final Link<T> leq;
        private final Link<T> gt;

        private Partition(final Link<T> leq, final Link<T> gt) {
            this.leq = leq;
            this.gt = gt;
        }

        private static <T extends Comparable<T>> Partition<T> partition(final T pivot, final Link<T> list) {
            /* Call to overloaded method, using null as leq and as gt. */
            return partition(pivot, list, null, null);
        }

        private static <T extends Comparable<T>> Partition<T> partition(final T pivot, final Link<T> list,
                                           final Link<T> leq, final Link<T> gt) {
            final Partition<T> result;
            if (list == null) {
                result = new Partition<T>(leq, gt);
            } else if (list.head.compareTo(pivot) <= 0) {
                result = partition(pivot, list.tail, add(list, leq), gt);
            } else {
                result = partition(pivot, list.tail, leq, add(list, gt));
            }
            return result;
        }
        /**
         * Adds the first element of head to the front of tail.
         */
        private static <T> Link<T> add(final Link<T> head, final Link<T> tail) {
            head.tail = tail;
            return head;
        }

    }
}
