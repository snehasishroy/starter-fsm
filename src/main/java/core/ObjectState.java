package core;

import models.State;

import java.util.Objects;

public class ObjectState<S> implements State<S> {
    S id;

    public ObjectState(S id) {
        this.id = id;
    }

    @Override
    public S getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectState<?> that = (ObjectState<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
