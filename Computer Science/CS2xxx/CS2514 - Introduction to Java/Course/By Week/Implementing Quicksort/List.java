/**
 * A linked list implementation.
 */
public class List {
    /**
     * The first link in the list.
     */
    private Link link;
    /**
     * Creates an empty list (by setting the first link to null).
     */
    public List() {
        link = null;
    }
    /**
     * Adds a new value to the front of the list.
     */
    public void add(int value) {
        link = new Link(link, value);
    }
    /** Delegates print action to a Link class method with the first link
     * passed as a parameter.
     */
    public void print() {
        Link.print(link);
    }

    /** Delegates as above. */
    public void append(final List that) {
        this.link = Link.append(this.link, that.link);
    }

    public void testPartition(final int pivot) {
        System.out.println("pivot is: " + pivot);
        print();
        final Partition partition = Partition.partition(pivot, link);
        System.out.println();
        Link.print(partition.leq);
        System.out.println();
        Link.print(partition. gt);
    }
    /** Delegates task of sorting to a class method in the Link class. */
    public void sort() {
        link = Link.sort(link);
    }

    private static class Link {
        /** The value contained in the current link. */
        private int head;
        /**
         * The next link in the list – null if this is the last link.
         */
        private Link tail;

        private static Link sort(final Link list) {
            final Link result;
            if ((list == null) || (list.tail == null)) {
                result = list;
            } else {
                final Link pivot = list;
                final Partition partition
                        = Partition.partition(pivot.head, list.tail);
                pivot.tail = sort(partition.gt);
                result =  append(sort(partition.leq), pivot);
            }
            return result;
        }

        /**
         * Creates a new Link whose tail link is the passed link and whose
         * value is the passed value.
         */
        private Link(final Link link, final int value) {
            this.head = value;
            this.tail = link;
        }

        private static Link add(final Link link, final int value) {
            return link;
        }
        /**
         * This is a class method so there's no problem calling it on an
         * empty link. Recursively prints the list, representing each node
         * by printing its value.
         */
        private static void print(final Link link) {
            if (link != null) {
                System.out.println(link.head);
                print(link.tail);
            }
        }

        /**
         * Appends the contents of list2 to the beginning of list1.
         *
         * Note we aim to have only one exit from our function, because
         * he claims it makes it easier to reason about our functions.
         */
        private static Link append(final Link list1, final Link list2) {
            final Link result;

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
    private static class Partition {
        private final Link leq;
        private final Link gt;

        private Partition(final Link leq, final Link gt) {
            this.leq = leq;
            this.gt = gt;
        }

        private static Partition partition(final int pivot, final Link list) {
            /* Call to overloaded method, using null as leq and as gt. */
            return partition(pivot, list, null, null);
        }

        private static Partition partition(final int pivot, final Link list,
                                           final Link leq, final Link gt) {
            final Partition result;
            if (list == null) {
                result = new Partition(leq, gt);
            } else if (list.head <= pivot) {
                result = partition(pivot, list.tail, add(list, leq), gt);
            } else {
                result = partition(pivot, list.tail, leq, add(list, gt));
            }
            return result;
        }
        /**
         * Adds the first element of head to the front of tail.
         */
        private static Link add(final Link head, final Link tail) {
            head.tail = tail;
            return head;
        }

    }
}
