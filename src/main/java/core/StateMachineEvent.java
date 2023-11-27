package core;

import models.Event;

import java.util.Objects;

public class StateMachineEvent<E> implements Event<E> {
    E id;

    public StateMachineEvent(E id) {
        this.id = id;
    }

    @Override
    public E getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateMachineEvent<?> that = (StateMachineEvent<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
