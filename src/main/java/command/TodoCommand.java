package command;

import duke.DukeException;

/**
 * Command for to-do tasks.
 */
public class TodoCommand extends TaskCommand {
    /**
     * Constructor
     * @param command user-input command
     * @param doesPrint whether to print messages
     */
    public TodoCommand(String command, boolean doesPrint) throws DukeException {
        super(command, doesPrint, 2);
    }
}
