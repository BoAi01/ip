package command;

import duke.Duke;
import duke.DukeException;
import duke.IndexOutOfBoundsDukeException;
import duke.NumberFormatDukeException;
import task.Task;
import task.TaskList;
import ui.TextUi;

/**
 * Mark a task as done
 */
public class MarkCommand extends Command {

    /**
     * Default constructor, saves the command
     *
     * @param command the user-input command
     */
    public MarkCommand(String command, boolean doesPrint) throws DukeException {
        super(command, doesPrint, 2);
    }

    /**
     * Execute the task
     * @param taskList the list of tasks
     * @param ui       a text UI
     */
    @Override
    public void execute(TaskList taskList, TextUi ui) throws DukeException {
        try {
            int idx = Integer.parseInt(command.substring(5)) - 1;
            Task t = taskList.get(idx);
            t.markDone();
            uiPrint(ui, String.format("Nice! I've marked this task as done:\n  %s", t));
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsDukeException();
        } catch (NumberFormatException e) {
            throw new NumberFormatDukeException();
        }
    }
}
