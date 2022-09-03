import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Game {

    //Definindo DIrecoes
    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;

    private Snake snake; //Definindo a Cobra
    private Board board;//Definindo o Tabuleiro
    private int direction;
    private boolean gameOver;

    //Contrutor Principal
    public Game(Snake snake, Board board)
    {
        this.snake = snake;
        this.board = board;
    }

    //Getters e Setters
    public Snake getSnake()
    {
        return snake;
    }
    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }
    public Board getBoard()
    {
        return board;
    }
    public void setBoard(Board board)
    {
        this.board = board;
    }
    public boolean isGameOver()
    {
        return gameOver;
    }
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }
    public int getDirection()
    {
        return direction;
    }
    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    //Atualizando o jogo em Intervalos e colocando o imput do jogador
    public void update()
    {
        System.out.println("Going to update the game");
        if (!gameOver) { //Se nao der game over
            if (direction != DIRECTION_NONE) { //se houver um imput
                Cell nextCell = getNextCell(snake.getHead()); //a proxima celula vai andar no imput

                if (snake.checkCrash(nextCell)) { //se bateu game over
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                }
                else {
                    snake.move(nextCell); //se nao vai se mover na proxima celula
                    if (nextCell.getCellType() == CellType.FOOD) { //se a proxima celula for comida
                        snake.grow(); //vai crescer
                        board.generateFood(); //e generar uma nova comida
                    }
                }
            }
        }
    }

    //Pegando a proxima Celula
    private Cell getNextCell(Cell currentPosition)
    {
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        //Movendo de acordo com o imput
        if (direction == DIRECTION_RIGHT) {
            col++;
        }
        else if (direction == DIRECTION_LEFT) {
            col--;
        }
        else if (direction == DIRECTION_UP) {
            row--;
        }
        else if (direction == DIRECTION_DOWN) {
            row++;
        }

        //Mandando o imput pra proxima celula
        Cell nextCell = board.getCells()[row][col];

        return nextCell;
    }

    public static void main(String[] args) {
        System.out.println("Going to start game");

        Scanner scanner = new Scanner(System.in);

        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(10, 10);
        Game newGame = new Game(initSnake, board);
        Buttons newButton = new Buttons();
        //KeyEvent event = new KeyEvent();
        newGame.gameOver = false;
        newGame.direction = DIRECTION_RIGHT;
        int lastDirection = newGame.direction;

        while (!newGame.gameOver){
            System.out.println("-------------------------------");
            System.out.println("Digite 0 para continuar na mesma direcao , Digite 1 para ir a direita,\n" +
                    "Digite -1 para ir a esquerda, Digite 2 para ir para cima e Digite -2 para ir para baixo");
            //event.getKeyCode();
            //newButton.keyPressed(event);
            newGame.direction = scanner.nextInt();
            if(newGame.direction == 0)
                newGame.direction = lastDirection;
            lastDirection = newGame.direction;
            newGame.update();

        }

    }

    //como capturar botoes do teclado em java
    //como colocar tick de atualizacao
    //mostrar a cobra na tela
}
