import javax.swing.JFrame;

public class MainGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Atrapa la Bola");
        JuegoPanel juegoPanel = new JuegoPanel();
        frame.add(juegoPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
