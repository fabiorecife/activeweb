package app.views.books;

import app.controllers.BooksController;
import org.javalite.activeweb.ViewSpec;
import org.junit.Test;

import java.util.Map;

import static org.javalite.common.Collections.map;

/**
 * @author Igor Polevoy: 3/31/12 5:13 PM
 */
public class ShowSpec extends ViewSpec {

    @Test
    public void shouldRenderOneBook() {

        setCurrentController(BooksController.class);

        Map book = map("author", "Douglas Adams", "title", "The Restaurant at the End of the Universe", "isbn", "ISBN 0-345-39181-0");

        String renderedPage = render("/books/show", map("book", book));

        a(renderedPage).shouldContain("<h2>Book: The Restaurant at the End of the Universe</h2>");
        a(renderedPage).shouldContain("<strong>Author:</strong> Douglas Adams, <strong>ISBN:</strong> ISBN 0-345-39181-0");
        a(contentFor("title").get(0)).shouldBeEqual("Book: The Restaurant at the End of the Universe");
    }
}
