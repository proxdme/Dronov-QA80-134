import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

import javax.management.Query;

public class TasksTest {

    @Test
    public void testMatchesWhenTitleContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertEquals("Позвонить родителям", simpleTask.getTitle());
    }

    @Test
    public void testMatchesWhenSubtasksContainsQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatchesWhenStartContainsQuery() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());
    }

    // TopicProject
    @Test
    public void testMatchesWhenTopicContainsQuery() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
    }

    @Test
    public void testMatchesWhenProjectContainsQuery() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Assertions.assertEquals("Приложение НетоБанка", meeting.getProject());
    }


}
