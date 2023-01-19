package com.company.Exe.MitkoVerson2.Mitko;
import com.company.Exe.MitkoVerson2.DataStructure.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LabyrinthGame {

    private List<String[]> labyrinth = csvReader.readCSVLabyrinth();//Прочита CSV файла и го съхранява в Лист от Стринг Масиви;
    private Point getStartPoint(List<String[]> lab){
        Point startPoint = null;
        for (int i = 0; i < lab.size(); i++) {
            for (int j = 0; j < lab.get(i).length; j++) {
                if (lab.get(i)[j].equals("M")) {
                    startPoint = new Point(j+1, i+1);
                }
            }
        }
        return startPoint;
    }//Намира началната точка на Митко;
    private Point getGOAL(List<String[]> lab) {
        Point goal = null;
        for (int i = 0; i < lab.size(); i++) {
            for (int j = 0; j < lab.get(i).length; j++) {
                if (lab.get(i)[j].equals("X")) {
                    goal = new Point(j+1, i+1);
                }
            }
        }
        return goal;
    }//Намира крайната точка до която Митко трябва да стигне;
    final private Point START = getStartPoint(labyrinth); //Запазва началната точка за да не я търсим постоянно;
    final private Point GOAL = getGOAL(labyrinth);// Запазва крайната точка за да не я търсим постоянно;
    private List<Point> getObstacles(){
        List<Point> obstacles = new ArrayList<>();
        for (int i = 0; i < labyrinth.size(); i++) {
            for (int j = 0; j < labyrinth.get(i).length; j++) {
                if (labyrinth.get(i)[j].equals("1")) {
                    Point newObstacles = new Point(j+1, i+1);
                    obstacles.add(newObstacles);
                }
            }
        }
        return obstacles;
    }// Намира къде се намират препядствията в лабиринта като всяко препядствие е Point и се съхраняват в лист от точки;
    private boolean hasObstacles(Point point, List<Point> obstacles){
        for (Point obstacle : obstacles) {
            if (point.x == obstacle.x && point.y == obstacle.y) {
                return true;
            }
        }
        return false;
    }//Проверява дали на дадена точка от лабиринта има препядствие;
    private List<Node> getChildren(Node parent) {
        List<Node> listChildren = new ArrayList<>();
        List<Point> obstacles = getObstacles();
        //up
        if (parent.curr.y < 8) {
            Point newCurr = new Point(parent.curr.x, parent.curr.y + 1);
            if (!hasObstacles(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        //down
        if (parent.curr.y > 1) {
            Point newCurr = new Point(parent.curr.x, parent.curr.y - 1);
            if (!hasObstacles(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        //right
        if (parent.curr.x < 13) {
            Point newCurr = new Point(parent.curr.x + 1, parent.curr.y);
            if (!hasObstacles(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        //left
        if (parent.curr.x > 1) {
            Point newCurr = new Point(parent.curr.x - 1, parent.curr.y + 1);
            if (!hasObstacles(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        return listChildren;
    }//Създава децата(следващите ходове на Митко) за всеки ход;
    private boolean isReviewed(List<Node> rev, Node temp){
        for (Node node : rev) {
            if (node.curr.x == temp.curr.x && node.curr.y == temp.curr.y) {
                return true;
            }
        }
        return false;
    }//Проверява дали вече сме били на тази позиция в лабиринта;
    public void solve(){
        Node root = new Node(START, null, null);
        Queue<Node> queue = new Queue<>();
        List<Node> reviewed = new ArrayList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node temp = queue.pop();

            if (isReviewed(reviewed, temp)) {
             continue;
            }
         reviewed.add(temp);

                if (temp.curr.x == GOAL.x && temp.curr.y == GOAL.y) {
                    writeDown(temp);
                    break;
                }
                List<Node> children = getChildren(temp);
                temp.children = children;
            for (Node child : children) {
                queue.push(child);
            }
            }
        }//Намиране на най-краткия път в лабиринта от началната до крайната точка.
    private void writeDown(Node solved) {
        Stack<Node> stack = new Stack<>();
        Node temp = solved;
        while (temp != null) {
            stack.push(temp);
            temp = temp.getParent();
        }
        int i = 0;
        while (!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print("( " + curr.curr.x + " : " + curr.curr.y + " )");
            i++;
        }
        System.out.println();
        i--;
        System.out.print("Solved with " + i + " moves");
    }//Извежда крайния реззултат (пътят по който Митко е стигнал до крайната точка
}
