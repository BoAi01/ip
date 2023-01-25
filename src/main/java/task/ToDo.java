package task;

/**
 * The to-do class extending from the Task.Task class.
 * To-do items have no starting date or deadlines.
 */
public class ToDo extends Task {
    /**
     * Default constructor
     *
     * @param description a string describing the to-do task
     */
    public ToDo(String description) {
        super(description);
        this.type = "T";
    }

    /**
     * Overriding
     *
     * @return the string representation of the to-do task
     */
    @Override
    public String toString() {
        return String.format("[%s]%s", this.type, super.toString());
    }
}
