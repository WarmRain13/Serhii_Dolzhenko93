import java.util.ArrayList;

public class TodoList {
    ArrayList<String> listArray = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        listArray.add(todo);
        System.out.println("Добавлено дело" + " " + "\"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if(isCorrectIndex(index)) {
            listArray.add(index, todo);
            System.out.println("Добавлено дело" + " " + "\"" + todo + "\"");
        }
        else {
            add(todo);
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
            }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if(isCorrectIndex(index)){
            System.out.println("Дело \""+ listArray.get(index) + "\" заменено на \""+ todo + "\"");
        listArray.set(index,todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if(index + 1 <= listArray.size()) {
            System.out.println("Дело \"" + listArray.get(index) + " \"удалено");
            listArray.remove(index);
        }else{
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return listArray;
    }
    private boolean isCorrectIndex(int index) {
        return index < listArray.size();
    }

}