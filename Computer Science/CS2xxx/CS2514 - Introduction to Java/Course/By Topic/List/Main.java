/**
 * Writing and testing a generic version of our List class.
 */
public class Main {
    public static void main(String[] args) {
        // Could leave out the second Integer and interference would cover
        // it
        final List<Integer> list = new List<Integer>();
        list.add(1);
        list.add(2);
        list.print();
        System.out.println();
        List.sort(list);
        list.print();
        System.out.println();
    }
}
