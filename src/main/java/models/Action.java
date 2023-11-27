package models;

public interface Action<S, E, T> {
    T execute(StateContext<S, E> context);
}
