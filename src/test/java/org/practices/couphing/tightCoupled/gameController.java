package org.practices.couphing.tightCoupled;

public class gameController {
    private contra game;

    public gameController(contra game){
        this.game= game;
    }
    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
