package models;

public interface StateContext<S, E> {
    Event<E> getEvent();
    State<S> getSource();
    State<S> getTarget();
}
