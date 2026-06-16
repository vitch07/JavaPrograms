package ui;

import doa.TodoDao;
import entity.Todo;

import java.util.Scanner;

public class TodoConsoleController {
    Scanner sc;
    TodoDao todo;
    TodoConsoleController(Scanner sc, TodoDao todo){
        this.sc = sc;
        this.todo = todo;
    }
    public void welcomeMessage(){
        System.out.println("Welcome to todo list maintainer !!!");
    }
    public void showMenu(){
        while(true){
            System.out.println("1: ADD");
            System.out.println("2: UPDATE");
            System.out.println("3:  DELETE");
            System.out.println("4:LIST ALL");
            System.out.println("Enter a choice");
            int choice = sc.nextInt();
            redirectChoice(choice);
        }
    }
    public void redirectChoice(int choice){
        switch(choice){
            case 1: add();
            break;

            case 2: update();
            break;

            case 3: delete();
            break;

            case 4: list_all();
            break;

            default:
                System.out.println("Invalid choice");
        }
    }
    private void list_all(){
        System.out.println(todo.findall());
    }
    private void delete(){
        System.out.println("Enter id which needs to be deleted ");
        int task_id = sc.nextInt();
        todo.deleteById(task_id);
    }
    private void update(){
        System.out.println("Enter id of the task to be changed");
        int id = sc.nextInt();
        System.out.println("Enter the task to be done ");
        String task = sc.nextLine();
        todo.update(new Todo(id,task,false));
    }

    public void add(){
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the task: ");
        String content = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the status: ");
        boolean done = sc.nextBoolean();

        todo.save(new Todo(id,content,done));
    }
}
