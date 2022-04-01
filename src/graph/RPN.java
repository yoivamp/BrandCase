package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式(Reverse Polish Expression，简称：RPN)转换工具类
 * 将中缀表达式转换成逆波兰表达式(后缀表达式)
 *
 * @author 喵vamp
 */
public class RPN {
    /**
     * 运算符数组
     */
    String[] operator = {"+", "-", "*", "/", "(", ")"};

    /**
     * 判断传入字符是否是运算符
     *
     * @param op 传入字符
     * @return 是否是运算符的boolean
     */
    public boolean isOperator(String op) {
        for (String s : operator) {
            if (s.equals(op)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取运算符优先等级
     *
     * @param op 运算符
     * @return 根据OP数组中运算符的顺序计算出运算符的优先等级：+ -是0级，* /是1级，( )是2级
     */
    public int getOperatorPriorityValue(String op) {
        for (int i = 0; i < operator.length; i++) {
            if (operator[i].equals(op)) {
                return i / 2;
            }
        }
        //不是运算符返回-1作为异常结果
        return -1;
    }

    /**
     * 将中缀表达式转换为后缀表达式
     *
     * @param expression 中缀表达式
     * @return 后缀表达式
     */
    public List<String> parse(List<String> expression) {
        // 运算符栈
        Stack<String> operatorStack = new Stack<>();
        //结果输出list
        List<String> output = new ArrayList<>();

        //遍历中缀表达式
        for (String str : expression) {
            //运算符进行判断
            if (isOperator(str)) {
                //"("直接入栈
                if ("(".equals(str)) {
                    operatorStack.push(str);
                    //")"弹出运算符栈元素到结果list中，直到遇到“(”
                } else if (")".equals(str)) {
                    while (!"(".equals(operatorStack.peek())) {
                        output.add(operatorStack.pop());
                    }
                    operatorStack.pop();
                    //如果为空栈或者栈顶元素为"("或者该运算符优先级高于运算符栈栈顶元素，该运算符直接入栈
                } else if (operatorStack.empty() || "(".equals(operatorStack.peek()) || getOperatorPriorityValue(str) > getOperatorPriorityValue(operatorStack.peek())) {
                    operatorStack.push(str);
                    //如果该运算符优先级低于运算符栈栈顶元素，则依次弹出栈顶元素，直到该运算符优先级高于运算符栈栈顶元素，此时该运算符再入栈
                } else {
                    //弹出运算符栈顶元素后，可能为空栈，此时应该直接让该运算符入栈
                    while (!(operatorStack.empty()) && getOperatorPriorityValue(operatorStack.peek()) > getOperatorPriorityValue(str)) {
                        output.add(operatorStack.pop());
                    }
                    operatorStack.push(str);
                }
            } else { //数字直接进入结果list
                output.add(str);
            }
        }
        //将运算符栈剩下的元素加到结果list中
        while (!operatorStack.empty()) {
            output.add(operatorStack.pop());
        }
        //返回结果list
        return output;
    }

    /**
     * 计算后缀表达式
     *
     * @param tokens 后缀表达式
     * @return 一个整数值
     */
    public double evalRPN(List<String> tokens) {
        Stack<Double> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                //遇到“”直接进行下一次循环
                if ("".equals(token)) {
                    continue;
                }
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    /**
     * 判断当前字符是否为数字
     * 计算式可能包含“”
     *
     * @param token 当前字符
     * @return 是否为数字
     */
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) || "".equals(token));
    }
}
