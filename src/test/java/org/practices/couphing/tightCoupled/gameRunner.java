package org.practices.couphing.tightCoupled;

public class gameRunner {
    public static void main(String[] args){
        var game= new contra();
        //var game= new pacman();
        var gameController= new gameController(game);
        gameController.run();
    }
}
