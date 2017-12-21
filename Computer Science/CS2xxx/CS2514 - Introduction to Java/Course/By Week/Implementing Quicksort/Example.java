public class Example {
    public static void main(final String[] args) {
        final List list1 = new List();
        list1.add(1);
        list1.add(2);
        list1.add(0); // 0 2 1
        final List list2 = new List();
        list2.add(5);
        list2.add(4);
        list2.add(6);
        list2.add(8); // 8 6 4 5

        list1.append(list2); // 8 6 4 5 0 2 1
        list1.sort(); // 0 1 2 4 5 6 8
        list1.print();
    }
}
