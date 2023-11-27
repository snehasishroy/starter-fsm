package core;

import models.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Application can exist in a finite number of states
// Driven by triggers which can be events or timers
// During transition, you can specify an action
record Node<S,E>(S source, S target, E event) {
}
public class StateMachine<S, E> {
    public State<S> currentState;
    Map<S, List<Node<S,E>>> choices = new HashMap<>();

    Map<S, State<S>> states = new HashMap<>();

    public StateMachine(S state) {
        State<S> objectState = new ObjectState<>(state);
        states.put(state, objectState);

        currentState = new ObjectState<>(state);
    }


    // need to pass data to action
    // trigger should have the appropriate data?
    // but there can be multiple type of triggers e.g. ApiCallback which can have
    // various type of data associated, how to model it?
    public void handleTrigger(Trigger trigger) {

    }

    public void handleEvent(E event) {
        S target = choices.getOrDefault(currentState.getId(), new ArrayList<>())
                .stream()
                .filter(node -> node.event().equals(event))
                .map(node -> node.target())
                .findAny()
                .orElseThrow();
        currentState = states.get(target);
    }

    public void addEvent(S source, S target, E event) {
        states.putIfAbsent(source, new ObjectState<>(source));
        states.putIfAbsent(target, new ObjectState<>(target));

        choices.computeIfAbsent(source, __ -> new ArrayList<>()).add(new Node<>(source, target, event));
    }

    public void addAction(S source, S target) {
        states.putIfAbsent(source, new ObjectState<>(source));
        states.putIfAbsent(target, new ObjectState<>(target));


    }
}
