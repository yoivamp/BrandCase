package graph;

import javax.swing.*;
import java.awt.*;

/**
 * @author 喵vamp
 */
public class BoxElement {
    /**
     * 容器
     */
    Frame frame;
    Box selectBox;
    Box sureBox;
    Box totalBox;
    /**
     * 文本域，文本框
     */
    TextField textField;
    TextArea areaLeft;
    TextArea areaRight;
    /**
     * 单选，复选按钮
     */
    Checkbox male;
    Checkbox female;
    Checkbox married;
    CheckboxGroup sex;
    /**
     * 下拉列表
     */
    Choice choice;
    /**
     * 按钮
     */
    Button ensure;

    public BoxElement() {
        frame = new Frame();
        selectBox = Box.createHorizontalBox();
        sureBox = Box.createHorizontalBox();
        totalBox = Box.createVerticalBox();

        textField = new TextField();
        areaLeft = new TextArea();
        areaRight = new TextArea("郑州\n" +
                "洛阳\n" +
                "岳阳");

        male = new Checkbox();
        female = new Checkbox();
        married = new Checkbox();
        sex = new CheckboxGroup();

        choice = new Choice();
        ensure = new Button();
    }

    public void setChoice() {
        choice.add("河南省");
        choice.add("河北省");
    }

    public void setCheckbox() {
        male.setLabel("男");
        female.setLabel("女");
        married.setLabel("是否已婚");
        male.setCheckboxGroup(sex);
        female.setCheckboxGroup(sex);
    }

    public void setButton() {
        ensure.setLabel("确定");
    }

    public void setFrame() {
        frame.setTitle("信息界面");
        frame.setVisible(true);
        frame.pack();
    }

    public void add() {
        //在selectBox添加组件
        selectBox.add(choice);
        selectBox.add(male);
        selectBox.add(female);
        selectBox.add(married);
        //在totalBox添加组件
        totalBox.add(areaLeft);
        totalBox.add(selectBox);
        //在sureBox添加组件
        sureBox.add(textField);
        sureBox.add(ensure);
        //frame添加组件并设置布局
        frame.add(totalBox);
        frame.add(sureBox, BorderLayout.SOUTH);
        frame.add(areaRight, BorderLayout.EAST);
    }
}
