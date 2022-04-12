package sk.uniza.fri.inf.todoList.io;

import sk.uniza.fri.inf.todoList.model.entity.TodoCategory;
import sk.uniza.fri.inf.todoList.model.entity.TodoItem;

import java.io.*;
import java.util.ArrayList;

/**
 * 11. 4. 2022 - 10:23
 *
 * @author Michal
 */
public class SerializedStorage implements ITodoStorage {

    public static final String TODOLIST_SAVE = "todolist.save";

    @Override
    public void load(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
        try (FileInputStream fis = new FileInputStream(TODOLIST_SAVE);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {

            ArrayList<TodoCategory> todoCategories = (ArrayList<TodoCategory>)inputStream.readObject();
            categories.addAll(todoCategories);

            items.addAll((ArrayList<TodoItem>)inputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {

        try (FileOutputStream fos = new FileOutputStream(TODOLIST_SAVE);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {
            outputStream.writeObject(categories);
            outputStream.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
