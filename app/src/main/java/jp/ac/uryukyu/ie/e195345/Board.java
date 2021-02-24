package jp.ac.uryukyu.ie.e195345;

public class Board implements Constant{
    private static String[][] position = new String[BOARD_LENGTH][BOARD_LENGTH];
    public static void setPosition(int ver, int hor, String stone) {
        position[ver][hor] = stone;
    }
    public static String getPosition(int ver, int hor) {
        return position[ver][hor];
    }

    //trueなら黒、falseなら白
    private Boolean stoneColor;
    public Boolean isStoneColor() {
        return stoneColor;
    }
    public void setStoneColor(Boolean stoneColor) {
        this.stoneColor = stoneColor;
    }

    public void firstShowBoard() {
        //碁盤の数字表示
        for(int i=0; i<BOARD_LENGTH;i++) {
            if(i==(BOARD_LENGTH-1)) {
                System.out.println(i);
                }
            else if(i==0) {
                System.out.print(" "+i+",");
            }
            else {
                System.out.print(i + ",");
                }
                }
        for(int j=0; j<BOARD_LENGTH; j++) {
            System.out.println(j);
        }

        for(int i=0; i<BOARD_LENGTH;i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                setPosition(i,j,EMPTY_STONE);
                System.out.print(EMPTY_STONE);
            }
            System.out.println("");
        }
    }

    //碁盤作成
    public void board(int ver, int hor, boolean stoneColor) {
        //stoneColorがtrueで黒,falseで白
        setStoneColor(stoneColor);

        for(int i=0; i<BOARD_LENGTH; i++) {
            //縦方向
            for(int j=0; j<BOARD_LENGTH; j++) {
                //横方向
                if((i==ver) && (j==hor)) {
                    if(isStoneColor()) {
                        setPosition(ver,hor,BLACK_STONE);
                        System.out.print(getPosition(ver,hor));
                    }
                    else{
                        setPosition(ver,hor,WHITE_STONE);
                        System.out.print(getPosition(ver,hor));
                    }
                }
                else {
                    System.out.print(getPosition(i,j));
                }
            }
            System.out.println("");
        }
    }
}