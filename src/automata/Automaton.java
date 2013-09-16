package automata;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: alexeyk
 * Date: 14.09.13
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class Automaton {
    private int tact;
    private State currentState;
    private State initialState;
    private Set<State> terminalStates;
    private List<State> states;
    private Set<Transition> transitions;

    public Automaton(){
        this.terminalStates = new HashSet<State>();
        this.states = new ArrayList<State>();
        this.transitions = new HashSet<Transition>();
    }


    public void setInitialState(State state){
        this.initialState = state;
    }

    public void addState(State state){
        this.states.add(state);
    }

    public void setStates(List<State> states){
        this.states = new ArrayList<State>(states);
    }

    public List<State> getStates(){
        return Collections.unmodifiableList(this.states);
    }

    public void addTransition(Transition transition){
        this.transitions.add(transition);
    }

    public Set<Transition> getTransitions(){
        return Collections.unmodifiableSet(this.transitions);
    }

    public void setTransitions(Set<Transition> transitions){
        this.transitions = new HashSet<Transition>(transitions);
    }


    public void work(List<String> inputs){
        initAutomaton();

        System.out.println("(" + this.initialState + ")");

        for(String input: inputs){

            System.out.println("-> " + input);


            if(this.terminalStates.contains(this.currentState)){
                System.out.println("FINISHED!");
                break;
            }

            this.currentState = this.currentState.work(input);
            System.out.println(currentState);
            this.tact++;
        }
    }

    private void initAutomaton(){
        this.currentState = this.initialState;

        for(Transition transition: transitions){
            transition.getFromState().addOutTransition(transition);
            transition.getToState().addInTransition(transition);
        }
    }
}
