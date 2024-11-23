import java.util.ArrayList;
import java.util.List;

// Memento Class
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator Class
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        System.out.println("Originator: Saving state to Memento.");
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        this.state = memento.getState();
        System.out.println("Originator: Restored state from Memento: " + state);
    }
}

// Caretaker Class
class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        if (index >= 0 && index < mementoList.size()) {
            return mementoList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid Memento index!");
        }
    }
}

// Main Class with updated name
public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // Setting states and saving them to Memento
        originator.setState("State1");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State2");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State3");
        System.out.println("Current State: " + originator.getState());

        // Restoring states from Memento
        originator.restoreStateFromMemento(caretaker.getMemento(0));
        originator.restoreStateFromMemento(caretaker.getMemento(1));
    }
}
