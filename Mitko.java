package com.company.Exe.Mitko.puzzle;
import com.company.Exe.Mitko.DataStructure.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mitko {

    final public Point GOAL = new Point(8,5);

    public Point [] getObstacles(){
        Point[] obstacles = new Point[21];
        obstacles[0] = new Point(3,3);
        obstacles[1] = new Point(4,3);
        obstacles[2] = new Point(4,4);
        obstacles[3] = new Point(4,5);
        obstacles[4] = new Point(4,6);
        obstacles[5] = new Point(5,6);
        obstacles[6] = new Point(6,6);
        obstacles[7] = new Point(7,6);
        obstacles[8] = new Point(8,6);
        obstacles[9] = new Point(9,6);
        obstacles[10] = new Point(10,6);
        obstacles[11] = new Point(10,5);
        obstacles[12] = new Point(10,4);
        obstacles[13] = new Point(11,4);
        obstacles[14] = new Point(12,4);
        obstacles[15] = new Point(10,3);
        obstacles[16] = new Point(10,2);
        obstacles[17] = new Point(9,2);
        obstacles[18] = new Point(8,2);
        obstacles[19] = new Point(8,3);
        obstacles[20] = new Point(7,3);
        return obstacles;
    }

    public boolean isContain(Point point, Point [] obstacles){
        for (Point obstacle : obstacles) {
            if (point.x == obstacle.x && point.y == obstacle.y) {
                return true;
            }
        }
        return false;
    }
    public List<Node> getChildren(Node parent) {
        List<Node> listChildren = new ArrayList<>();
        Point[] obstacles = getObstacles();
        //up
        if (parent.curr.y < 8) {
            Point newCurr = new Point(parent.curr.x, parent.curr.y + 1);
            if (!isContain(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        //down
        if (parent.curr.y > 1) {
            Point newCurr = new Point(parent.curr.x, parent.curr.y - 1);
            if (!isContain(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        //right
        if (parent.curr.x < 13) {
            Point newCurr = new Point(parent.curr.x + 1, parent.curr.y);
            if (!isContain(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        //left
        if (parent.curr.x > 1) {
            Point newCurr = new Point(parent.curr.x - 1, parent.curr.y + 1);
            if (!isContain(newCurr, obstacles)) {
                Node child = new Node(newCurr, null, parent);
                    listChildren.add(child);
            }
        }
        return listChildren;
    }
    public boolean isReviewed(List<Node> rev, Node temp){
        for (Node node : rev) {
            if (node.curr.x == temp.curr.x && node.curr.y == temp.curr.y) {
                return true;
            }
        }
        return false;
    }
    public void solve(Point start){
        Node root = new Node(start, null, null);
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
        }
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
    }
}
