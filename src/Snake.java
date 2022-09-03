import java.util.LinkedList; //Para representar a cobra

public class Snake {

    private LinkedList<Cell> snakePartList = new LinkedList<>(); //Criando a Lista para a Cobra
    private Cell head; //Criando a Celula pra cabeca

    //Construtor
    public Snake(Cell initPos){
        head = initPos; //alocando a cabeca na posicao inicial
        snakePartList.add(head); //colocando a cabeca na lista(cobra)
        head.setCellType(CellType.SNAKE_NODE); //defininfo a cabeca como celula parte da cobra
    }

    public void grow() { snakePartList.add(head); } //quando comer crescer

    public void move(Cell nextCell) //Se movendo
    {
        System.out.println("Snake is moving to "
                + nextCell.getRow() + " "
                + nextCell.getCol());
        Cell tail = snakePartList.removeLast(); //andando pra frente remove o ultimo
        tail.setCellType(CellType.EMPTY); //removendo o ultimo fazendo virar uma celula vazia

        head = nextCell; //andando pra frente
        head.setCellType(CellType.SNAKE_NODE); //fazendo a celula da frente virar parte da cobra
        snakePartList.addFirst(head); //e por fim adicionando a cobra essa celula
    }

    public boolean checkCrash(Cell nextCell) //Verificando se bateu
    {
        System.out.println("Going to check for Crash");
        for (Cell cell : snakePartList) { //for each nas celulas da cobra
            if (cell == nextCell) { //se a proxima celula for uma celula de cobra bateu
                return true;
            }
        }
        return false;
    }

    //Getters e Setters
    public LinkedList<Cell> getSnakePartList()
    {
        return snakePartList;
    }

    public void
    setSnakePartList(LinkedList<Cell> snakePartList)
    {
        this.snakePartList = snakePartList;
    }

    public Cell getHead() { return head; }

    public void setHead(Cell head) { this.head = head; }
}

