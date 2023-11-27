import core.StateMachine;

public class Main {

    enum States {
        ORDER_PLACED, ORDER_CONFIRMED;
    }

    enum Events {
        DELIVERED;
    }

    public static void main(String[] args) {
        StateMachine<States, Events> fsm = new StateMachine<>(States.ORDER_PLACED);
        System.out.println(fsm.currentState);

        fsm.addEvent(States.ORDER_PLACED, States.ORDER_CONFIRMED, Events.DELIVERED);
        fsm.handleEvent(Events.DELIVERED);

        System.out.println(fsm.currentState);
    }
}