package graph;

import java.awt.*;

/**
 * @author 喵vamp
 */
public class Element {
    /**
     * 框架
     */
    Frame frame;
    /**
     * 标签
     */
    Label userType;
    Label userName;
    Label password;
    /**
     * 下拉列表
     */
    Choice choice;
    /**
     * 文本框
     */
    TextField inputName;
    TextField inputPwd;
    /**
     * 按钮
     */
    Button ensure;
    Button cancel;
    /**
     * 单选按钮
     */
    Checkbox male;
    Checkbox female;
    CheckboxGroup select;

    /**
     * 生成所需组件
     */
    public Element() {
        frame = new Frame();

        userType = new Label();
        userName = new Label();
        password = new Label();

        choice = new Choice();

        inputName = new TextField();
        inputPwd = new TextField();

        ensure = new Button();
        cancel = new Button();

        male = new Checkbox();
        female = new Checkbox();
        select = new CheckboxGroup();
    }

    public void setFrame() {
        frame.setTitle("登陆界面");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(600, 600, 500, 500);
        frame.setLayout(null);
    }

    public void setLabel() {
        userType.setText("请选择用户类型");
        userType.setBounds(100, 110, 100, 50);

        userName.setText("请输入用户名");
        userName.setBounds(100, 200, 100, 50);

        password.setText("请输入密码");
        password.setBounds(100, 300, 100, 50);
    }

    public void setChoice() {
        choice.add("教师");
        choice.add("学生");
        choice.setBounds(200, 120, 100, 30);
    }

    public void setTextField() {
        inputName.setBounds(200, 220, 100, 30);

        inputPwd.setBounds(200, 320, 100, 30);
        inputPwd.setEchoChar('*');
    }

    public void setButton() {
        ensure.setLabel("确定");
        ensure.setBounds(100, 400, 80, 50);

        cancel.setLabel("取消");
        cancel.setBounds(350, 400, 80, 50);
    }

    public void setCheckBox() {
        male.setLabel("男");
        male.setBounds(350, 200, 50, 50);

        female.setLabel("女");
        female.setBounds(350, 300, 50, 50);

        male.setCheckboxGroup(select);
        female.setCheckboxGroup(select);
    }

    public void addFrame() {
        frame.add(userType);
        frame.add(userName);
        frame.add(password);

        frame.add(inputName);
        frame.add(inputPwd);

        frame.add(choice);
        frame.add(male);
        frame.add(female);

        frame.add(ensure);
        frame.add(cancel);
    }

    public void setLayout(){
        frame.setLayout(new  BorderLayout());
    }

    /**
     *    Element elment = new Element();
     *         elment.setFrame();
     *         elment.setLabel();
     *         elment.setChoice();
     *         elment.setTextField();
     *         elment.setButton();
     *         elment.setCheckBox();
     *         elment.addFrame();
     *         elment.setLayout();
     */
}
