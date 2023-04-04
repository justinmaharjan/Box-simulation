import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoxMovingGame extends JPanel implements ActionListener {

    private int x = 100;
    private int y = 100;
    private int xSpeed = 5;
    private int ySpeed = 3;
    private Timer timer;
    private int width;
    private int height;

    public BoxMovingGame() {
        JFrame frame = new JFrame("Box Moving Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(this);

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new MyKeyListener());
        setFocusable(true);

        width = frame.getContentPane().getWidth();
        height = frame.getContentPane().getHeight();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        x += xSpeed;

        if (x <= 0 || x + 50 >= width) {
            xSpeed = -xSpeed;
        }

        y += ySpeed;

        if (y <= 0 || y + 50 >= height) {
            ySpeed = -ySpeed;
        }

        repaint();
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            // handle user input
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                case KeyEvent.VK_LEFT:
                    xSpeed = -5;
                    break;
                case KeyEvent.VK_RIGHT:
                    xSpeed = 5;
                    break;
                case KeyEvent.VK_UP:
                    ySpeed = -3;
                    break;
                case KeyEvent.VK_DOWN:
                    ySpeed = 3;
                    break;
                default:
                    xSpeed = 0;
                    ySpeed = 0;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new BoxMovingGame();
    }
}
