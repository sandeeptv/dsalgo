package com.dsalgo.problems.tree;

import com.dsalgo.problems.other.Bnode;

import java.util.Stack;

public class ZigZagTraversal {



    private static void zigZagTraversal(Bnode root) {
        int leftToRight=1;
        Bnode temp;
        Stack<Bnode> currentLevel=new Stack<Bnode>();
        Stack<Bnode> nextLevel=new Stack<Bnode>();

        System.out.println("Zig Zag Traversal");
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            temp = currentLevel.pop();
            if(temp!=null)
            {
                System.out.println(temp.getVal());
                if(leftToRight==1)
                {
                    if (temp.getLeft() != null)
                        nextLevel.push(temp.getLeft());
                    if (temp.getRight() != null)
                        nextLevel.push(temp.getRight());
                }
                else
                {
                    if (temp.getRight() != null)
                        nextLevel.push(temp.getRight());
                    if (temp.getLeft() != null)
                        nextLevel.push(temp.getLeft());
                }

            }
            if(currentLevel.isEmpty())
            {
                leftToRight=1-leftToRight;
                while(!nextLevel.isEmpty())
                {
                    currentLevel.push(nextLevel.pop());
                }
            }


        }
    }

}
