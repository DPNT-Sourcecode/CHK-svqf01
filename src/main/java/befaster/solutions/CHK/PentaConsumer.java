package befaster.solutions.CHK;

@FunctionalInterface
public interface PentaConsumer<A, B, C , D, E> {

    void accept(A a, B b, C c, D d, E e);

}