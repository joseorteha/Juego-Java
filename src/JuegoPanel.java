import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class JuegoPanel extends JPanel implements ActionListener, KeyListener {
    private int jugadorX = 250, jugadorY = 250, jugadorAncho = 50, jugadorAlto = 50;
    private int bolaX = 100, bolaY = 100, bolaAncho = 20, bolaAlto = 20;
    private int velocidadBolaX = 2, velocidadBolaY = 2;
    private Timer timer;

    public JuegoPanel() {
        this.setFocusable(true);
        this.addKeyListener(this);
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(jugadorX, jugadorY, jugadorAncho, jugadorAlto);
        g.setColor(Color.RED);
        g.fillOval(bolaX, bolaY, bolaAncho, bolaAlto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Movimiento de la bola
        bolaX += velocidadBolaX;
        bolaY += velocidadBolaY;

        // Rebote de la bola en los bordes de la ventana
        if (bolaX <= 0 || bolaX >= getWidth() - bolaAncho) {
            velocidadBolaX = -velocidadBolaX;
        }
        if (bolaY <= 0 || bolaY >= getHeight() - bolaAlto) {
            velocidadBolaY = -velocidadBolaY;
        }

        // Colisión entre el jugador y la bola
        if (new Rectangle(jugadorX, jugadorY, jugadorAncho, jugadorAlto).intersects(new Rectangle(bolaX, bolaY, bolaAncho, bolaAlto))) {
            bolaX = (int)(Math.random() * getWidth());  // Reposicionar la bola
            bolaY = (int)(Math.random() * getHeight());
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Movimiento del jugador
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT && jugadorX > 0) {
            jugadorX -= 10;
        }
        if (tecla == KeyEvent.VK_RIGHT && jugadorX < getWidth() - jugadorAncho) {
            jugadorX += 10;
        }
        if (tecla == KeyEvent.VK_UP && jugadorY > 0) {
            jugadorY -= 10;
        }
        if (tecla == KeyEvent.VK_DOWN && jugadorY < getHeight() - jugadorAlto) {
            jugadorY += 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
