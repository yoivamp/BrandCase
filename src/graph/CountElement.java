package graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 喵vamp
 */
public class CountElement {
    /**
     * 框架
     */
    JFrame frame;
    /**
     * 面板
     */
    Box disPlay;
    JPanel select;

    /**
     * 显示框
     */
    JTextField show;
    /**
     * 按钮
     */
    JButton clear;
    List<JButton> numbers;
    /**
     * 选项卡集合
     */
    List<String> stringList;

    public CountElement() {
        frame = new JFrame("计算器");

        disPlay = Box.createHorizontalBox();
        select = new JPanel();

        show = new JTextField();

        clear = new JButton("清空");
        numbers = new ArrayList<>();

        String[] strings = {"1", "2", "3", "0", "-", "(", "4", "5", "6", ".", "/", ")", "7", "8", "9", "+", "*", "="};
        stringList = Arrays.asList(strings);
    }

    public void setFrame() {
        frame.pack();
        frame.setVisible(true);
    }

    public void setPanel() {
        select.setLayout(new GridLayout(3, 6, 4, 4));
    }

    public void setButton() {
        numbers.forEach(jButton -> jButton.setFont(new Font("宋体", Font.BOLD, 18)));
    }

    public void setTextField(String string) {
        show.setText(string);
    }


    public void addFrame() {
        disPlay.add(show);
        disPlay.add(clear);
        frame.add(disPlay, BorderLayout.NORTH);
        stringList.forEach(str -> numbers.add(new JButton(str)));
        numbers.forEach(jButton -> select.add(jButton));
        frame.add(select);
    }
}
