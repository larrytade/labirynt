package com.company.Exe.Mitko.puzzle;
import java.util.List;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Node {

Point curr;
List<Node> children;
Node parent;


    public Node(Point curr, List<Node> children, Node parent) {
        this.curr = curr;
        this.children = children;
        this.parent = parent;
    }

    public Node getParent() {
        return this.parent;
    }
    public Point getCurr(){
        return this.curr;
    }



}

