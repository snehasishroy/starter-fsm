package core;

import models.Event;
import models.State;
import models.StateContext;

public class DefaultStateContext<S, E> implements StateContext<S, E> {
    final State<S> source;
    final State<S> target;
    final Event<E> event;

    public DefaultStateContext(State<S> source, State<S> target, Event<E> event) {
        this.source = source;
        this.target = target;
        this.event = event;
    }

    @Override
    public Event<E> getEvent() {
        return event;
    }

    @Override
    public State<S> getSource() {
        return source;
    }

    @Override
    public State<S> getTarget() {
        return target;
    }
}
