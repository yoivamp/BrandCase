package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 喵vamp
 */
public class GraphEvent {
    /**
     * 计算器界面类
     */
    CountElement countElement;
    /**
     * 用户输入的计算式集合
     */
    List<String> expression = new ArrayList<>();
    /**
     * 计算工具类
     */
    RPN rpn = new RPN();
    /**
     * 数字暂存集合
     */
    List<String> pause = new ArrayList<>();

    /**
     * 创建计算器界面
     */
    public void creatGraph() {
        countElement = new CountElement();
        countElement.setFrame();
        countElement.setPanel();
        countElement.setButton();
        countElement.addFrame();
    }

    /**
     * 输入计算式
     */
    public void input() {
        countElement.numbers.forEach(button -> button.addActionListener(event -> {
            String actionCommand = event.getActionCommand();
            //如果点击“=”按钮，直接计算结果
            if ("=".equals(actionCommand)) {
                //计算之前先将pause剩下的数字添加到计算式中
                expression.add(String.join("", pause));
                compute();
                pause.clear();
                return;
            } else {
                //如果是运算符先将pause中的数字添加到计算式，再添加运算符
                if (rpn.isOperator(actionCommand)) {
                    expression.add(String.join("", pause));
                    expression.add(actionCommand);
                    pause.clear();
                } else {    //将多位数或小数先存入pause中
                    pause.add(actionCommand);
                }
            }
            //将计算式展现在显示框
            countElement.setTextField(String.join("", expression) + String.join("", pause));
        }));
    }

    /**
     * 计算结果
     */
    public void compute() {
        //调用RPN的方法计算结果并展现在显示框
        List<String> parse = rpn.parse(expression);
        countElement.setTextField(String.join("", expression) + "=" + rpn.evalRPN(parse));
        //清空计算式
        expression.clear();
    }

    /**
     * 清空按钮
     */
    public void clear() {
        countElement.clear.addActionListener(event -> {
            countElement.setTextField("");
            expression.clear();
            pause.clear();
        });
    }
}
