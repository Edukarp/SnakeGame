public class Cell {

    //Estabelecendo Variaveis
    private final int row; //linha
    private final int col; //coluna
    private CellType cellType;

    //Criando Construtor
    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    //Getters e Setters
    public CellType getCellType()
    {
        return cellType;
    }
    public void setCellType(CellType cellType)
    {
        this.cellType = cellType;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
}

