package common;

public interface BeforeAfterPractice extends TargetPractice {
    void before();
    void after();

    @Override
    default void run() {
        before();
        after();
    }
}
