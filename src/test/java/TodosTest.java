import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskToResult() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] result = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(new Task[]{simpleTask}, result);
    }

    @Test
    public void shouldTestSomeTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(3, "Позвонить мне");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleTask2);
        Task[] result = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(new Task[]{simpleTask}, result);
    }

    @Test
    public void shouldTestOneTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        Task[] result = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(new Task[]{simpleTask}, result);
    }


    @Test
    public void shouldTestZeroTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить маме"));
        todos.add(new SimpleTask(2, "Купить продукты"));
        Task[] result = todos.search("Убраться в комнате");
        Assertions.assertArrayEquals(new Task[0], result);
    }

}

