import javax.swing.*;
import java.awt.*;

public class MainScreen {
    JFrame frame;
    JLabel image;
    JLabel text;
    JProgressBar progressBar;

    MainScreen() {
        createGUI();
        addBackground();
        addImage();
        addText();
        addProgressBar();
        runningPBar();
    }

    public void createGUI() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void addBackground() {
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("back.jpg"));
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setBounds(0, 0, 600, 600);
        frame.add(backgroundPanel);
        backgroundPanel.setLayout(null);
    }

    public void addImage() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("electricity.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(90, 70, 400, 200);
        frame.add(image);
    }

    public void addText() {
        text = new JLabel("Electricity Management System");
        text.setFont(new Font("Helvetica", Font.BOLD, 22));
        text.setBounds(120, 300, 400, 50);
        text.setForeground(Color.black);
        frame.add(text);
    }

    public void addProgressBar() {
        progressBar = new JProgressBar();
        progressBar.setBounds(100, 380, 400, 30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.black);
        progressBar.setForeground(new Color(238, 245, 255));
        progressBar.setValue(0);
        frame.add(progressBar);
    }

    public void runningPBar() {
        new Thread(() -> {
            int i = 0;
            while (i <= 100) {
                try {
                    Thread.sleep(50);
                    progressBar.setValue(i);
                    i++;
                    if (i == 100)
                        frame.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            SwingUtilities.invokeLater(() -> new Login());
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainScreen::new);
    }
}
