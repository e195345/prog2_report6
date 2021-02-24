package jp.ac.uryukyu.ie.e195345;

public class Judge implements Constant{
    //win変数が5または-5になったときに勝利となる
    private int win = 0;
    public int getWin() {
        return win;
    }
    public void setWin(int win) {
        this.win += win;
    }
    public void resetWin() {
        this.win = 0;
    }

    public boolean winJudge() {
        //横に5個並んだ場合の勝利判定
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                if(Board.getPosition(i, j)==BLACK_STONE) {
                    setWin(1);
                }
                else if(Board.getPosition(i, j)==WHITE_STONE) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }

            if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
                return true;
            }
            else {
                resetWin();
            }
        }

        //縦に5個並んだ場合の勝利判定
        for(int j=0; j<BOARD_LENGTH; j++){
            for(int i=0; i<BOARD_LENGTH; i++)
             {
                if(Board.getPosition(i, j)==BLACK_STONE) {
                    setWin(1);
                }
                else if(Board.getPosition(i, j)==WHITE_STONE) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }

            if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
                return true;
            }
            else {
                resetWin();
            }
        }

        //左斜めに5個並んだ場合の勝利判定
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                if((i==j) && (Board.getPosition(i, j)==BLACK_STONE)) {
                    setWin(1);
                }
                else if((i==j) && (Board.getPosition(i, j)==WHITE_STONE)) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }
            }
        if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
            return true;
        }
        else {
            resetWin();
        }

        //右斜めに5個並んだ場合の勝利判定
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                if((i+j == (BOARD_LENGTH - 1)) && (Board.getPosition(i, j)==BLACK_STONE)) {
                    setWin(1);
                }
                else if((i+j == (BOARD_LENGTH - 1)) && (Board.getPosition(i, j)==WHITE_STONE)) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }
            }
        if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
            return true;
        }
        else {
            resetWin();
        }

        return false;
    }

    }
