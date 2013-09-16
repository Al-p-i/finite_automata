import automata.Automaton;
import automata.State;
import automata.Transition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexeyk
 * Date: 14.09.13
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args){
        //states
        Automaton automaton = new Automaton();

        State ON = new State("ON");
        State OFF = new State("OFF");
        automaton.addState(ON);
        automaton.addState(OFF);

        //transitions
        automaton.addTransition(new Transition(ON, OFF, "OFF"));
        automaton.addTransition(new Transition(ON, ON, "ON"));
        automaton.addTransition(new Transition(OFF, ON, "ON"));
        automaton.addTransition(new Transition(OFF, OFF, "ON"));
        automaton.addTransition(new Transition(OFF, OFF, "OFF"));

        automaton.setInitialState(OFF);

        //input
        List<String> input = new ArrayList<String>();
        input.add("ON");
        input.add("ON");
        input.add("ON");
        input.add("ON");
        input.add("ON");

        automaton.work(input);
    }
}
