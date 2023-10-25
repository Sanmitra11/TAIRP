import java.awt.event.*;
import javax.swing.*;

public class StudentGradeAnalyzer {

    private JFrame frame;
    private JPanel panel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    private JLabel label4;
    private JTextField textField4;

    public StudentGradeAnalyzer() {
        frame = new JFrame("Student Grade Calculator");
        panel = new JPanel();

        label1 = new JLabel("Student Name:");
        label1.setBounds(30,15, 100,30);

        textField1 = new JTextField();
        textField1.setBounds(110, 15, 200, 30);

        label2 = new JLabel("Number of Grades:");
        label2.setBounds(30,15, 100,30);

        textField2 = new JTextField();
        textField2.setBounds(110, 15, 200, 30);

        label3 = new JLabel("Grade 1:");
        label3.setBounds(30,15, 100,30);

        textField3 = new JTextField();
        textField3.setBounds(110, 15, 200, 30);

        button1 = new JButton("Calculate");
        button1.setBounds(130,90,80,25);

        label4 = new JLabel("Overall Average:");
        label4.setBounds(30,15, 100,30);

        textField4 = new JTextField();
        textField4.setBounds(110, 15, 200, 30);

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(button1);
        panel.add(label4);
        panel.add(textField4);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numGrades = Integer.parseInt(textField2.getText());
                double[] grades = new double[numGrades];
                for (int i = 0; i < numGrades; i++) {
                    grades[i] = Double.parseDouble(textField3.getText());
                }
                double average = 0;
                for (double grade : grades) {
                    average += grade;
                }
                average /= numGrades;
                textField4.setText(String.format("%.2f", average));
            }
        });

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }

    public void setVisible(boolean b) {
    }
}
