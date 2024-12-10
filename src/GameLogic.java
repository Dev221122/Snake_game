import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLogic {

    Game g;


    public GameLogic(Game g){
        this.g=g;
    }
    public void addTail(){


        g.snakes.add(new Snake(g.snakes.get(g.snakes.size()-1).xPosition-20,g.snakes.get(g.snakes.size()-1).yPosition));




    }

    public void specialAddTail(){

        for (int i=g.snakes.size()-1;i>g.snakes.size()-8;i--){
            g.snakes.add(new Snake(g.snakes.get(i).xPosition-20,g.snakes.get(i).yPosition));
        }

    }

    public boolean eat(){


        return new Rectangle(g.snakes.get(0).xPosition,g.snakes.get(0).yPosition,20,20).intersects(new Rectangle(g.f.foodX,g.f.foodY,10,10));

    }

    public boolean specialEat(){

        return new Rectangle(g.snakes.get(0).xPosition,g.snakes.get(0).yPosition,20,20).intersects(new Rectangle(special.specX,special.specY,5,5));
    }

    public boolean isDie(){

        for (int i=1;i<g.snakes.size();i++){

            if(g.snakes.get(0).xPosition==g.snakes.get(i).xPosition&&g.snakes.get(0).yPosition==g.snakes.get(i).yPosition){
                return true;
            }
        }

        return false;
    }

    public boolean engelCrash(){

        boolean flag=false;
        boolean flag2=false;
        flag2= new Rectangle(g.snakes.get(0).xPosition,g.snakes.get(0).yPosition,20,20).intersects(new Rectangle(g.e.engelX,g.e.engelY,20,400));
        if(d!=null){
            flag= new Rectangle(g.snakes.get(0).xPosition,g.snakes.get(0).yPosition,20,20).intersects(new Rectangle(d.engelX,d.engelY,20,150));


        }

        return flag||flag2;

    }


    Engel d;
    public void addEngel(){
        if(g.score==100){

            d=new Engel(80,80);

        }
    }

    SpecialFood special;

    int tempscore=0;
    public void makespecFood(){


        if(g.score%50==0&&special==null&&tempscore!=g.score){

            Random r1=new Random();
            int rand1=r1.nextInt(0,700);
            int rand2=r1.nextInt(0,700);


            tempscore=g.score;


            special=new SpecialFood(rand1,rand2);


        }

    }

    public void outRangeX(){


        if(g.snakes.get(0).xPosition<0){

            g.snakes.get(0).xPosition=750;

        }if(g.snakes.get(0).xPosition>900){
            g.snakes.get(0).xPosition=0;
        }


    }

    public void outRangeY(){

        if(g.snakes.get(0).yPosition<0){

            g.snakes.get(0).yPosition=750;

        }if(g.snakes.get(0).yPosition>900){
            g.snakes.get(0).yPosition=0;
        }

    }


    public boolean moveRight(){



        if(g.c== KeyEvent.VK_RIGHT){

            g.snakes.get(0).xPosition+=10;



            return true;
        }


        return false;
    }

    public boolean moveLeft(){



        if((g.c==KeyEvent.VK_LEFT)){

            g.snakes.get(0).xPosition-=10;

            return true;
        }



        return false;

    }


    public boolean moveUp(){


        if(g.c==KeyEvent.VK_UP){


            g.snakes.get(0).yPosition-=10;

            return true;
        }




        return false;
    }

    public boolean moveDown(){

        if(g.c==KeyEvent.VK_DOWN){

            g.snakes.get(0).yPosition+=10;


            return true;
        }



        return false;

    }

    public void follow(){

        for (int i=g.snakes.size()-1;i>0;i--){

            g.snakes.get(i).xPosition=g.snakes.get(i-1).xPosition;

            g.snakes.get(i).yPosition=g.snakes.get(i-1).yPosition;
        }
    }


    public void faster() {
        if (g.snakes.size() % 10 == 0&&g.t.getDelay()>0) {


            g.t.setDelay(g.t.getDelay()-3);

            System.out.println(g.t.getDelay());


        }
    }






}
