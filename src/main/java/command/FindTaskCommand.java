package command;

import duke.DukeException;
import task.TaskList;
import ui.TextUi;

/**
 * A command for finding a class
 */
public class FindTaskCommand extends TaskCommand {
    /**
     * Default constructor
     * @param command the user-input command
     * @param doesPrint whether to print messaegs
     */
    public FindTaskCommand(String command, boolean doesPrint) throws DukeException {
        super(command, doesPrint, 2);
    }

    @Override
    public void execute(TaskList taskList, TextUi ui) throws DukeException {
        String stringToSearch = getCommandContent(command);
        String taskListString = "Here are the matching tasks in your list:\n"
                + taskList.getTaskNameContains(stringToSearch).getTaskListString(true);
        uiPrint(ui, taskListString);
    }
}
