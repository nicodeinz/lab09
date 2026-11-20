package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    void setString(String string);

    String getString();

    List<String> getList();

    void print();
}
