import core.StateMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        fsm.addAction(States.ORDER_PLACED, States.ORDER_CONFIRMED, (ctx) -> {
            System.out.println("State transition is happening!!!");
            System.out.println(ctx.getEvent() + " " + ctx.getSource() + " " + ctx.getTarget());
            return true;
        });
        fsm.handleEvent(Events.DELIVERED);

        System.out.println(fsm.currentState);
    }
}