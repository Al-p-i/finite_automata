package automata;

/**
 * Created with IntelliJ IDEA.
 * User: alexeyk
 * Date: 14.09.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class Transition {
    private final State fromState;
    private final State toState;
    private final String input;

    public Transition(State fromState, State toState, String input) {
        this.fromState = fromState;
        this.toState = toState;
        this.input = input;
    }

    public State getFromState() {
        return fromState;
    }

    public State getToState() {
        return toState;
    }

    public String getInput() {
        return input;
    }
}
