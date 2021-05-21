import javax.swing.*;
import java.awt.*;

public class TestScrollPanel {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(1280, 720);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // // 创建文本区域组件
        // JTextArea textArea = new JTextArea();
        // textArea.setLineWrap(true);                         // 自动换行
        // textArea.setFont(new Font(null, Font.PLAIN, 18));   // 设置字体

        
        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        // JScrollPane scrollPane = new JScrollPane(
        //         new TrainerPanel().trainerPanel(),
        //         ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        //         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        // );
        JTextField jtf = new JTextField(20);
        System.out.println(jtf.getText());

        jf.setContentPane(jtf);
        jf.setVisible(true);
    }

}