package automata;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: alexeyk
 * Date: 14.09.13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class State {
    private final Map<String, Set<Transition>> outTransitions;
    private final Map<String, Set<Transition>> inTransitions;
    private final String name;
    private static final Random rand = new Random();

    public State(String name){
        this.name = name;
        this.outTransitions = new HashMap<String, Set<Transition>>();
        this.inTransitions = new HashMap<String, Set<Transition>>();
    }

    void addOutTransition(Transition transition){
        if(!this.outTransitions.containsKey(transition.getInput())){
            this.outTransitions.put(transition.getInput(), new HashSet<Transition>());
        }
        this.outTransitions.get(transition.getInput()).add(transition);
    }

    void addInTransition(Transition transition){
        if(!this.inTransitions.containsKey(transition.getInput())){
            this.inTransitions.put(transition.getInput(), new HashSet<Transition>());
        }
        this.inTransitions.get(transition.getInput()).add(transition);
    }

    public State work(String input){
        if(!outTransitions.containsKey(input)){
            throw new RuntimeException("NO NEXT STATE FOR THIS INPUT!");
        }
        return getRandomOutTransition(input).getToState();
    }


    private Transition getRandomOutTransition(String input){
        int nOfVariants = outTransitions.get(input).size();
        Transition[] transitionsForInput = new Transition[nOfVariants];
        outTransitions.get(input).toArray(transitionsForInput);
        return transitionsForInput[rand.nextInt(nOfVariants)];
    }

    @Override
    public String toString() {
        return "( " + name + " )";
    }
}
