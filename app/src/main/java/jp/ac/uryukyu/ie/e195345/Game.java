package jp.ac.uryukyu.ie.e195345;

public class Game {
    Stone stone = new Stone();
    Judge judge = new Judge();
    Board board = new Board();

    private boolean gameLoop = true;
    public boolean isGameLoop() {
        return gameLoop;
    }
    public void setGameLoop(boolean gameLoop) {
        this.gameLoop = gameLoop;
    }

    //石の色を決める
    //奇数の時は黒、偶数のときは白
    private int loop=1;
    public int getLoop() {
        return loop;
    }
    public void setLoop(int loop) {
        this.loop = loop;
    }

    public void gameStart() {
        board.firstShowBoard();
        while(isGameLoop()) {
            //gameLoopがtrueの場合ゲーム継続
            if(getLoop()%2 == 1) {
                //奇数の時は黒
                System.out.println("黒のターンです");
                stone.stoneConfig(true);
                if(stone.getStoneSet()) {
                    if(!judge.winJudge()) {
                    //winJudgeがfalseのときゲーム継続,trueで勝利判定へ
                    setLoop(2);
                    }
                    else {
                        System.out.println("黒の勝利です！");
                        setGameLoop(false);
                    }
                }
                else {
                    setLoop(1);
                }
            }
            //loopが偶数なので白のターン
            else{
                System.out.println("白のターン");
                stone.stoneConfig(false);
                if(stone.getStoneSet()) {
                    if(!judge.winJudge()) {
                        //winJudgeがfalseのときゲーム継続、trueで勝利判定へ
                        setLoop(1);
                        }
                        else {
                            System.out.println("白の勝利です！");
                            setGameLoop(false);
                        }
                    }
                else {
                    setLoop(2);
                }
            }

        }
    }
}