package command;

import duke.DukeException;
import duke.IndexOutOfBoundsDukeException;
import duke.NumberFormatDukeException;
import task.Task;
import task.TaskList;
import ui.TextUi;

/**
 * Command for deleting a task
 */
public class DeleteCommand extends TaskCommand {

    /**
     * Default constructor
     * @param command the user-input command
     * @param doesPrint whether to print messages
     */
    public DeleteCommand(String command, boolean doesPrint) throws DukeException {
        super(command, doesPrint, 2);
    }

    /**
     * Execute the task
     * @param taskList the list of tasks
     * @param ui       a text UI
     * @throws DukeException
     */
    public void execute(TaskList taskList, TextUi ui) throws DukeException {
        String indexToDelete = getCommandContent(command);
        try {
            int idx = Integer.parseInt(indexToDelete) - 1;
            Task t = taskList.get(idx);
            taskList.remove(idx);
            String toPrint = String.format("Noted. I've removed this task:\n  %s\n"
                    + "Now you have %d tasks in the list.", t, taskList.size());
            uiPrint(ui, toPrint);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsDukeException();
        } catch (NumberFormatException e) {
            throw new NumberFormatDukeException();
        }
    }

    public String execute(TaskList taskList) throws DukeException {
        String indexToDelete = getCommandContent(command);
        try {
            int idx = Integer.parseInt(indexToDelete) - 1;
            Task t = taskList.get(idx);
            taskList.remove(idx);
            String toPrint = String.format("Noted. I've removed this task:\n  %s\n"
                    + "Now you have %d tasks in the list.", t, taskList.size());
            return toPrint;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsDukeException();
        } catch (NumberFormatException e) {
            throw new NumberFormatDukeException();
        }
    }
}
