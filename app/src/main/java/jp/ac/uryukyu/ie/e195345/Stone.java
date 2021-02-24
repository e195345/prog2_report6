package jp.ac.uryukyu.ie.e195345;

public class Stone implements Constant{
    Board board = new Board();
    //石を置けたらtrue,置けなかったらfalse
    private boolean stoneSet;
    public boolean getStoneSet() {
        return stoneSet;
    }
    public void setStoneSet(boolean stoneSet) {
        this.stoneSet = stoneSet;
    }

    private int verPosition;
    private int horPosition;
    public int getVerPosition() {
        return verPosition;
    }
    public void setTatePosition(int verPosition) {
        this.verPosition = verPosition;
    }
    public int getHorPosition() {
        return horPosition;
    }
    public void setHorPosition(int horPosition) {
        this.horPosition = horPosition;
    }

    //石を配置する
    @SuppressWarnings("resource")
    public void stoneConfig(boolean stoneColor) {
        //引数stoneColorがtrueで黒、falseで白
        System.out.println("石の位置を入力してください");
        try {
        int verPosition = new java.util.Scanner(System.in).nextInt();
        int horPosition = new java.util.Scanner(System.in).nextInt();
        if((verPosition>=0&&horPosition>=0)&&(verPosition<BOARD_LENGTH && horPosition<BOARD_LENGTH)) {
            if(Board.getPosition(verPosition, horPosition)==EMPTY_STONE) {
                setTatePosition(verPosition);
                setHorPosition(horPosition);
                board.board(getVerPosition(), getHorPosition(), stoneColor);
                setStoneSet(true);
            }
            //既に置かれている位置の場合
            else {
                setStoneSet(false);
                System.out.println("石が置かれていない場所を選択してください");
            }
        }
        //範囲外を選択している場合
        else {
            setStoneSet(false);
            System.out.println("0～"+(BOARD_LENGTH-1)+"で入力してください");
        }
        }
        //整数以外で入力している場合
        catch(Exception e) {
            setStoneSet(false);
            System.out.println("整数で入力してください");
        }
    }

}
