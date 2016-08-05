package hello;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * You could have used Spring Data to provide an implementation of your
 * repository over a wide range of SQL or NoSQL stores, but for the
 * purpose of this guide, you will simply use a naive implementation
 * that simulates some latency (network service, slow delay, etc).
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
