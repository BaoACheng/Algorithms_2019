package sword_to_offer;

import java.util.Stack;

public class Q005_QueueImplementWithStack {
    /*
     * 问题描述:
     *  用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     * 解决思路(初始):
     *  队列的特点是先进先出，而栈的特点是后进先出，那么考虑使用一个队列进行类似的入栈操作，然后将数据依次出栈存储在另一个栈中，则数据
     *  与队列一致。
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */
    // stack1用来读入数据，stack2用来存储
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

}
