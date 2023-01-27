package task;

import java.time.LocalDate;

import duke.DukeException;
import ui.Parser;

/**
 * A deadline class extends from the Task.Task.
 * It has a deadline attribute on top of the task.
 */
public class Deadline extends Task {
    protected LocalDate time;

    /***
     * Constructor.
     *
     * @param description the content of the user command
     * @throws DukeException when the command is incomplete
     */
    public Deadline(String description) throws DukeException {
        super();
        int indexOfBy = description.indexOf("/by");
        if (indexOfBy < 0) {
            throw new DukeException("This is not a complete command, missing dates. \n"
                    + "Please try again");
        }
        this.time = Parser.parseDate(description.substring(indexOfBy + "/by ".length()));
        this.name = description.substring(0, indexOfBy - " ".length());
        this.type = "D";
    }

    /**
     * Returns the string representation of the task.
     * The deadline date is included.
     *
     * @return string representation of a deadline task, where the deadline is specified
     */
    @Override
    public String toString() {
        return String.format("[%s]%s (by: %s)", type, super.toString(), Task.printDate(time));
    }
}
