package org.practices.couphing.looselyCoupled;

public class gameController {
    private gameControllerInterface game;

    public gameController(gameControllerInterface game){
        this.game= game;
    }
    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
