package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {

    private String current;
    private List<String> PrintedString = new LinkedList<>();

    @Override
    public void setString(String string) {
        this.current = Objects.requireNonNull(string);
    }

    @Override
    public String getString() {
        return this.current;
    }

    @Override
    public List<String> getList() {
        return List.copyOf(this.PrintedString);
    }

    @Override
    public void print() {

        if(this.current == null){
            throw new IllegalStateException("no string to print");
        }
        IO.println(this.current);
        PrintedString.add(this.current);
    }

}