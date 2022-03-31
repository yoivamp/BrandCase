package graph;

import java.awt.*;

/**
 * @author 喵vamp
 */
public class NumberBoundary {

    /**
     * 框架
     */
    Frame frame;
    /**
     * 标签
     */
    Label request;
    Label input;
    Label prompt;
    Label summarize;
    /**
     * 文本域
     */
    TextField digit;
    TextField message;
    TextField judge;
    /**
     * 按钮
     */
    Button ensure;
    Button cancel;

    /**
     * 生成所需组件
     */
    public NumberBoundary() {
        frame = new Frame();

        request = new Label();
        input = new Label();
        prompt = new Label();
        summarize = new Label();

        digit = new TextField();
        message = new TextField();
        judge = new TextField();

        ensure = new Button();
        cancel = new Button();
    }

    public void setFrame() {
        frame.setTitle("登陆界面");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(600, 600, 500, 500);
        frame.setLayout(null);
    }

    public void setLabel() {
        request.setText("请输入100以内的数字");
        request.setBounds(200, 40, 250, 50);

        input.setText("请输入");
        input.setBounds(100, 110, 50, 50);

        prompt.setText("提示");
        prompt.setBounds(100, 200, 50, 50);

        summarize.setText("总结");
        summarize.setBounds(100, 300, 50, 50);
    }

    public void setTextField() {
        digit.setBounds(150, 110, 250, 50);

        message.setBounds(150, 200, 250, 50);
        message.setForeground(Color.black);
        message.setBackground(Color.blue);

        judge.setBounds(150, 300, 250, 50);
        judge.setBackground(Color.yellow);
        judge.setForeground(Color.red);
    }


    public void setButton() {
        ensure.setLabel("确定");
        ensure.setBounds(100, 400, 80, 50);

        cancel.setLabel("取消");
        cancel.setBounds(350, 400, 80, 50);
    }

    public void addFrame() {
        frame.add(request);
        frame.add(input);
        frame.add(prompt);
        frame.add(summarize);

        frame.add(digit);
        frame.add(message);
        frame.add(judge);

        frame.add(ensure);
        frame.add(cancel);
    }
}

/**
 *
 *      * 目标数字
 *      private static int target;
 *      *
 *      实际数字private static int fact;
 *    //创建页面
 *         NumberBoundary boundary = new NumberBoundary();
 *         boundary.setFrame();
 *         boundary.setLabel();
 *         boundary.setTextField();
 *         boundary.setButton();
 *         boundary.addFrame();
 *
 *         //获取实际数字
 *         boundary.digit.addActionListener((event) -> {
 *             TextField source = (TextField) event.getSource();
 *             fact = Integer.parseInt(source.getText());
 *         });
 *
 *
 *         //点击确定按钮
 *         boundary.ensure.addActionListener((event) -> {
 *             target = (int) (Math.random() * 100);
 *
 *             //提示文字显示
 *             String str = fact < target ? "偏小" : "偏大";
 *             str = fact != target ? str : "相等";
 *             boundary.message.setText(str);
 *
 *             //总结文字显示
 *             String result = fact == target ? "正确" : "错误";
 *             boundary.judge.setText(result);
 *         });
 *
 *         //点击取消按钮关闭页面
 *         boundary.cancel.addActionListener((event) -> boundary.frame.dispose());
 */

