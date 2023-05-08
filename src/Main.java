import javax.swing.*;

public class Main {

    private static MainForm mainForm;

    public static void main(String[] args) {
        mainForm = new MainForm();
        mainForm.setContentPane(mainForm.getMainWindow());
        mainForm.setSize(500,400);
        mainForm.setVisible(true);
        mainForm.setTitle("Návštěvníci <jmeno>");
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}