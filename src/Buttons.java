import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Buttons extends JFrame implements KeyListener {

    JLabel label;
    //ImageIcon icon;
    Color backgroundGreen = new Color(61, 94, 10);
    Color snakeGreen = new Color(145, 194, 70);
    public Buttons(){
        //icon = new ImageIcon("teste.jpg");

        //Background
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(560, 560);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
        this.getContentPane().setBackground(backgroundGreen);

        //Snake
        label = new JLabel();
        label.setBounds(0, 0, 35, 35);
        label.setBackground(snakeGreen);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.black));
        label.setOpaque(true);

        this.add(label);
        this.setVisible(true);
    }

    public void keyTyped(KeyEvent event){ //Chamado quando uma tecla é digitada(pressionada tbm). usa-se KeyChar, char output
        switch (event.getKeyChar()){ //Usando WASD pra locomocao
            case 'a': label.setLocation(label.getX()-10, label.getY());
                break;
            case 'w': label.setLocation(label.getX(), label.getY()-10);
                break;
            case 's': label.setLocation(label.getX(), label.getY()+10);
                break;
            case 'd': label.setLocation(label.getX()+10, label.getY());
                break;
        }
    }

    public void keyPressed(KeyEvent event) { //Chamado quando uma tecla é pressionada. usa-se KeyCode, int output
        //System.out.println("Tecla " + event.getKeyChar() + " foi pressionada");
        switch (event.getKeyCode()){ //Usando as setinhas para locomocao
            case 37: label.setLocation(label.getX()-10, label.getY());
                break;
            case 38: label.setLocation(label.getX(), label.getY()-10);
                break;
            case 40: label.setLocation(label.getX(), label.getY()+10);
                break;
            case 39: label.setLocation(label.getX()+10, label.getY());
                break;
        }

    }

    public void keyReleased(KeyEvent event){ //chamado quando uma tecla deixa de ser pressionada
        System.out.println("Voce soltou a tecla " + event.getKeyChar());
        System.out.println("Voce soltou a tecla de codigo " + event.getKeyCode());

    }

    public void mouseClicked(MouseEvent event) {
        System.out.println("Botão clicado " + event.getButton());//só que vai retornar um  int e não uma string.
    }

}
