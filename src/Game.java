
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;



public class Game extends JPanel implements ActionListener,KeyListener {




    int score=0;
    ArrayList<Snake>snakes;

    GameLogic gl;
    Engel e;

    Timer t=new Timer(50,this);
    Food f;
    public Game(){

        gl=new GameLogic(this);
        snakes=new ArrayList<>();

        snakes.add(new Snake(4,4));


        t.start();

        e=new Engel(400,200);


        f=new Food(80,80);


    }









    @Override
    public void paint(Graphics g){

        super.paint(g);

        setBackground(Color.black);


        g.setColor(Color.red);
        for (Snake s:snakes){

            g.fillOval(s.xPosition,s.yPosition,20,20);
        }

        g.fillRect(f.foodX,f.foodY,10,10);





        g.setColor(Color.yellow);
        g.fillRect(e.engelX,e.engelY,20,400);

        

        if(gl.d!=null){

            g.fillRect(gl.d.engelX,gl.d.engelY,20,150);

        }

        if(gl.special!=null){

            g.fillRect(gl.special.specX,gl.special.specY,5,5);


            if(gl.specialEat()){


                gl.specialAddTail();
                gl.special=null;
            }

        }


        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));

        g.drawString("Score: " + score, 10, 20);
    }

    public void repaint(){

        super.repaint();
    }




    int movedirX=5;
    int movedirY=5;


    int c;
    int b;


    @Override
    public void keyPressed(KeyEvent e) {





        b=e.getKeyCode();

        if(b==KeyEvent.VK_LEFT&&c!=KeyEvent.VK_RIGHT||b==KeyEvent.VK_RIGHT&&c!=KeyEvent.VK_LEFT||b==KeyEvent.VK_UP&&c!=KeyEvent.VK_DOWN||b==KeyEvent.VK_DOWN&&c!=KeyEvent.VK_UP){


            c =b;
        }











    }



    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {




    }




    int randfX;
    int randfY;
    @Override
    public void actionPerformed(ActionEvent e) {

        gl.outRangeX();

        gl.outRangeY();

        gl.makespecFood();

        if(gl.special!=null&&gl.specialEat()){
            score+=10;
        }

        if(gl.eat()){

            gl.faster();



            score+=5;
            System.out.println(score);

            Random r1=new Random();

            randfX=r1.nextInt(0,700);
            randfY=r1.nextInt(0,700);






               if(score==105&&(randfX>=gl.d.engelX-5&&randfX<=gl.d.engelX+35)&&(randfY>=gl.d.engelY-5&&randfY<=gl.d.engelY+160+5)||((randfX>=400-5&&randfX<420+5)&&(randfY>=200-5&&randfY<=800+5))){


                   randfX=3;

                   randfY=3;
            }




            f=null;
            f=new Food(randfX,randfY);
            gl.addTail();
            System.out.println("22");
        }

        if(gl.moveUp()){

            snakes.get(0).yPosition-=movedirY;
        }if(gl.moveDown()){

            snakes.get(0).yPosition+=movedirY;
        }if(gl.moveRight()){

            snakes.get(0).xPosition+=movedirX;
        }if(gl.moveLeft()){

            snakes.get(0).xPosition-=movedirX;
        }



        if(gl.isDie()){

            t.stop();
        }

        if(gl.engelCrash()){
            t.stop();
        }



        gl.follow();

        repaint();



        gl.addEngel();
    }


}
