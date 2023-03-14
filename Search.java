import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 *  Класс, предоставляющий функции поиска в глубину и ширину над множеством (списком) объектов
 *
 */
public class Search {

    /**
     * Алгоритм поиска в ширину.
     * @param list список, представляющий множество объектов, по которым ведется поиск
     * @param startIndex индекс элемента, с которого начинается поиск
     * @param goal условие окончания поиска
     * @param successors функция, возвращающая список объектов, переход к которым возможен от заданного объекта
     * @return элемент, на котором завершился поиск или null если обход происходил без условия окончания поиска
     */
    public static <T> T BFS(List<T> list, int startIndex, Predicate<T> goal, Function<T, List<T>> successors) {
        Queue<T> frontier = new ArrayDeque<>();
        ArrayList<T> explored = new ArrayList<>();

        frontier.offer(list.get(startIndex));
        while(!frontier.isEmpty()) {
            T current = frontier.poll();
            if (goal != null)
                if (goal.test(current))
                    return current;
            explored.add(current);
            for (T successor: successors.apply(current))
                if (!explored.contains(successor))
                    frontier.offer(successor);
        }
        return null;
    }

    /**
     * Алгоритм поиска в глубину.
     * @param list список, представляющий множество объектов, по которым ведется поиск
     * @param startIndex индекс элемента, с которого начинается поиск
     * @param goal условие окончания поиска
     * @param successors функция, возвращающая список объектов, переход к которым возможен от заданного объекта
     * @return элемент, на котором завершился поиск или null если обход происходил без условия окончания поиска
     */
    public static <T> T DFS(List<T> list, int startIndex, Predicate<T> goal, Function<T, List<T>> successors) {
        Stack<T> frontier = new Stack<>();
        ArrayList<T> explored = new ArrayList<>();

        frontier.push(list.get(startIndex));
        while(!frontier.empty()) {
            T current = frontier.pop();
            if (goal != null)
                if (goal.test(current))
                    return current;
            explored.add(current);
            for (T successor: successors.apply(current))
                if (!explored.contains(successor))
                    frontier.push(successor);
        }
        return null;
    }
}
