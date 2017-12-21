```java
public class PIC /* FILL IN #1 */ {
    private String[] things;
    public PIC(String[] things) {
        this.things = things;
    }
    /* FILL IN #2 */
}
```

* need to fill in this code in the question

* the only purpose of the class is to iterate over the attribute `things`

* provide the code to complete it

```java
public class PIC implements Iterable<String> {
    private String[] things;
    public PIC(String[] things) {
        this.things = things;
    }
    /* FILL IN #2 */
}
```

* have implemented Iterable, now need to provide an Iterator

    * iterator holds the state for iterating over and provides the `next()` and `hasNext()` methods

    * can either use an inner class or an anonymous class (anonymous class is slightly easier)

```java
public class PIC implements Iterable<String> {
    private String[] things;
    public PIC(String[] things) {
        this.things = things;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            // visibility modifier doesn't matter because you can't access the attribute anyway    
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < things.length;
            }

            @Override
            public int getNext() {
                return things[position++];
            }
        };
    }
}
```
