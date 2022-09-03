public class Board {
    final int ROW_COUNT, COL_COUNT; //tamanho do tabuleiro
    private Cell[][] cells; //matrix de celulas é o tabuleiro

    //Contrutor do tabuleiro
    public Board(int rowCount, int columnCount)
    {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;

        cells = new Cell[ROW_COUNT][COL_COUNT]; //criando o Tabuleiro
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                    cells[row][column] = new Cell(row, column);
            }
        }
    }

    //Getters e Setters
    public Cell[][] getCells()
    {
        return cells;
    }
    public void setCells(Cell[][] cells)
    {
        this.cells = cells;
    }

    public void generateFood() //Criando a Comida em um local aleatorio do Board
    {
        System.out.println("Going to generate food");
        //definindo posicoes da comida
        int row;
        int column;
        while(true){ //fica em loop ate achar uma posicao valida
            //alocando aleatoriamente
            row = (int)(Math.random() * ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);
            //se a celula nao for uma parte de cobra coloca
            if(cells[row][column].getCellType()!=CellType.SNAKE_NODE)
                break;
        }
        cells[row][column].setCellType(CellType.FOOD);
        System.out.println("Food is generated at: " + row + " " + column);
    }

}
