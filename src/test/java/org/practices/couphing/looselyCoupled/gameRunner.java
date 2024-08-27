package org.practices.couphing.looselyCoupled;

public class gameRunner {
    public static void main(String[] args){
        var game= new pacman();
        var gameController= new gameController(game);
        gameController.run();
    }
}
