
package org.Graphics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import javax.media.opengl.GL;
import org.Graphics.Path;
import org.Graphics.Vertex;
import org.Graphics.Wall;

/**
 *
 * @author omar-
 */
public class KingSpider implements Serializable{
    
    private static boolean isChasing;
    private boolean returning;
    
    String lastMove;
    
    Stack<String> stack = new Stack<String>();
    
    final float  homeX; 
    final float  homeY;
    public static float speed = 0.2f;
    public float x,y;
    int moveDir =0;
    

    public KingSpider(float x,float y) {
        this.x = x;
        this.y = y;
        this.homeX = x;
        this.homeY = y;
    }
    
    private boolean collision(ArrayList<Wall> walls, float newX,float newY){
        float yMax = newY + .7f;
        float yMin = newY - .7f;
        float xMax = newX + .7f;
        float xMin = newX - .7f;
        
        Vertex v1 = new Vertex(xMin,yMax); //top left
        Vertex v2 = new Vertex(xMax,yMax); //top right
        Vertex v3 = new Vertex(xMax,yMin); //bottom right
        Vertex v4 = new Vertex(xMin,yMin); //bottom left
        
        Wall top = new Wall(v1,v2); // top
        Wall right = new Wall(v2,v3); // right
        Wall bottom = new Wall(v3,v4); // bottom
        Wall left = new Wall(v4,v1); // left
        
        boolean collisionTop;
        boolean collisionBottom;
        boolean collisionLeft;
        boolean collisionRight;
        boolean collision = false;

        for(Wall w: walls){
            collisionTop = w.getV1().getY() <= top.getV1().getY() || w.getV2().getY() <= top.getV2().getY();
            collisionBottom = w.getV1().getY() >= bottom.getV1().getY() || w.getV2().getY() >= bottom.getV2().getY();
            collisionLeft = w.getV1().getX() >= left.getV1().getX() || w.getV2().getX() >= left.getV2().getX();
            collisionRight = w.getV1().getX() <= right.getV1().getX() || w.getV2().getX() <= right.getV2().getX();
            collision = collisionTop && collisionBottom && collisionLeft && collisionRight;
            if(collision){
                isChasing = false;
                break;
            }
        }
        System.err.println("----- Collision: " + collision);
        return collision;
    }
    
    public static void drawKingSpider(GL gl) {
        float s0 = .4f; // size
        float s1 = .1f; // size
        float s2 = .6f; // size
        float s3 = .3f; // size
        float s4 = .2f; // size
        float s5 = .15f; // size
        float s6 = .5f; // size
        float s7 = 1f; // size
        
        if (isChasing){
            gl.glColor3f(.1f, .1f, .1f);
        }
        else {
            gl.glColor3f(.5f, .1f, .1f);
        }
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s7,s7 - .3f,-14.9f);
            gl.glVertex3f(s7,s7 - .3f,-14.9f);
            gl.glVertex3f(s7,-s7,-14.9f);
            gl.glVertex3f(-s7,-s7,-14.9f);
        gl.glEnd();
        if (isChasing){
            gl.glColor3f((0.5f+speed), .1f, .1f);
        }
        else{
              gl.glColor3f(.5f, .5f, .5f);
        }
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s2,s2,-14.9f);
            gl.glVertex3f(s2,s2,-14.9f);
            gl.glVertex3f(s2,-s2 - .1f,-14.9f);
            gl.glVertex3f(-s2,-s2 - .1f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s3,s3 + .7f,-14.9f);
            gl.glVertex3f(s3,s3 + .7f,-14.9f);
            gl.glVertex3f(s3,-s3 + .9f,-14.9f);
            gl.glVertex3f(-s3,-s3 + .9f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s4 - 1,s4 + .3f,-14.9f);
            gl.glVertex3f(s4 + 1,s4 + .3f,-14.9f);
            gl.glVertex3f(s4 + 1,-s4 + .5f,-14.9f);
            gl.glVertex3f(-s4 - 1,-s4 + .5f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s4 - 1,s4 - .1f,-14.9f);
            gl.glVertex3f(s4 + 1,s4 - .1f,-14.9f);
            gl.glVertex3f(s4 + 1,-s4 + .1f,-14.9f);
            gl.glVertex3f(-s4 - 1,-s4 + .1f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s4 - 1,s4 - .5f,-14.9f);
            gl.glVertex3f(s4 + 1,s4 - .5f,-14.9f);
            gl.glVertex3f(s4 + 1,-s4 - .3f,-14.9f);
            gl.glVertex3f(-s4 - 1,-s4 - .3f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s5 - 1,s5 - .5f,-14.9f);
            gl.glVertex3f(s5 + 1,s5 - .5f,-14.9f);
            gl.glVertex3f(s5 + 1,-s5 - .3f,-14.9f);
            gl.glVertex3f(-s5 - 1,-s5 - .3f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s6,s6 - .7f,-14.9f);
            gl.glVertex3f(s6 - 0.8f,s6 - .7f,-14.9f);
            gl.glVertex3f(s6 - 0.8f,-s6 - .7f,-14.9f);
            gl.glVertex3f(-s6,-s6 - .7f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s6 + 0.8f,s6 - .7f,-14.9f);
            gl.glVertex3f(s6,s6 - .7f,-14.9f);
            gl.glVertex3f(s6,-s6 - .7f,-14.9f);
            gl.glVertex3f(-s6 + 0.8f,-s6 - .7f,-14.9f);
        gl.glEnd();
        
        gl.glColor3f(0.3f, 1f, 0.3f);
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s1 - .22f,s1 + .7f,-14.9f);
            gl.glVertex3f(s1  - .22f,s1 + .7f,-14.9f);
            gl.glVertex3f(s1  - .22f,-s1 + 1f,-14.9f);
            gl.glVertex3f(-s1  - .22f,-s1 + 1f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s1 + .22f,s1 + .7f,-14.9f);
            gl.glVertex3f(s1  + .22f,s1 + .7f,-14.9f);
            gl.glVertex3f(s1  + .22f,-s1 + 1f,-14.9f);
            gl.glVertex3f(-s1  + .22f,-s1 + 1f,-14.9f);
        gl.glEnd();
        gl.glColor3f(.8f, 0.1f, 0f);
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s0 - .3f,s0 + .3f,-14.9f);
            gl.glVertex3f(s0  - .7f,s0 + .3f,-14.9f);
            gl.glVertex3f(s0  - .7f,-s0 + .8f,-14.9f);
            gl.glVertex3f(-s0 - .3f,-s0 + .8f,-14.9f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
            gl.glVertex3f(-s0 + .7f,s0 + .3f,-14.9f);
            gl.glVertex3f(s0  + .3f,s0 + .3f,-14.9f);
            gl.glVertex3f(s0  + .3f,-s0 + .8f,-14.9f);
            gl.glVertex3f(-s0 + .7f,-s0 + .8f,-14.9f);
        gl.glEnd();
    }
    
public void AIMovement(GL gl, ArrayList<Wall> walls, ArrayList<Path> paths){
    
    
        gl.glTranslatef(x, y, 0);
        
        
        
        Path[] currentPath = this.getPath(paths);
        
        if (isChasing){
            returning = false;
        }
        if ((!Worm.isInSafeRoom() && !returning && (isChasing || (currentPath[0] == Worm.getPath(paths) || (currentPath[1] != null && currentPath[1] == Worm.getPath(paths)  ))))){
            isChasing = true;

            if (currentPath[0] == Worm.getPath(paths) || (currentPath[1] != null && currentPath[1] == Worm.getPath(paths) )){
                
                if ( !collision(walls,x+.14f,y) && (int)this.x < (int)Worm.x){
                    moveDir = 2;
                }
                else if (!collision(walls,x-.14f,y) &&(int)this.x > (int)Worm.x){
                    moveDir = 1;
                }
                else if (!collision(walls,x,y+.14f) &&(int) this.y < (int)Worm.y){
                    moveDir = 3;
                }
                else if (!collision(walls,x,y-.14f) &&(int) this.y > (int)Worm.y){
                    
                    moveDir = 4;
                }
        }
            else if (moveDir !=0 && lastMoveCollision(walls)) {
                if (lastMove.charAt(1) == 'x'){
                    if (!collision(walls,x,y+speed) && this.y < Worm.y){
                    moveDir = 3;
                }
                else if (!collision(walls,x,y-speed) && this.y > Worm.y){
                    
                    moveDir = 4;
                }
                }
                else
                    if ( !collision(walls,x+speed,y) && this.x < Worm.x){
                    moveDir = 2;
                }
                else if (!collision(walls,x-speed,y) &&this.x > Worm.x){
                    moveDir = 1;
                }
            }

            switch(moveDir){
                
                case 1:if(!collision(walls,x-speed,y)){
                    System.out.println(moveDir);
                    x -= speed;
                    lastMove = "-x";
                    stack.push(lastMove);
                }break; // left

                case 2:if(!collision(walls,x+speed,y)){
                    System.out.println(moveDir);
                    x += speed;
                    lastMove = "+x";
                    stack.push(lastMove);
                }break; // right

                case 3:if(!collision(walls,x,y+speed)){
                    System.out.println(moveDir);
                    y += speed;
                    lastMove = "+y";
                    stack.push(lastMove);
                }break; // up

                case 4:if(!collision(walls,x,y-speed)){
                    System.out.println(moveDir);
                    y -= speed;
                    lastMove = "-y";
                    stack.push(lastMove);
                }break; // down
            }

            
        }
        else if (moveDir !=0  &&  !stack.isEmpty() && (!isChasing || Worm.isInSafeRoom())){
            returning =true;
            isChasing = false;
            String s = stack.pop();
            System.out.println(s);
            int homeDir = 0;
            
                 if ( s.equals("-x")){
                    homeDir = 2;
                }
                else if ( s.equals("+x") ){
                    homeDir = 1;
                }
                else if (s.equals("-y") ){
                    homeDir = 3;
                }
                else if (s.equals("+y") ){
                    
                    homeDir = 4;
                }
            
            switch(homeDir ){
                
                case 1:if(!collision(walls,x-speed,y)){
                    System.out.println("re "+homeDir);
                    x -= speed;
                }break; // left

                case 2:if(!collision(walls,x+speed,y)){
                    System.out.println("re "+homeDir);
                    x += speed;
                }break; // right

                case 3:if(!collision(walls,x,y+speed)){
                    System.out.println("re "+homeDir);
                    y += speed;
                }break; // up

                case 4:if(!collision(walls,x,y-speed)){
                    System.out.println("re "+homeDir);
                    y -= speed;
                }break; // down
            }
                
            
        }
        
        if (stack.isEmpty()){
                returning = false;
            }
        
        if ((int) this.x == (int) Worm.x && (int) this.y ==  (int) Worm.y || (Math.abs(this.x - Worm.x) < 1.5 && Math.abs(this.y - Worm.y) < 1.5 )){
            Worm.alive = false;
            this.x = this.homeX;
            this.y = this.homeY;
            stack = new Stack<String>();
            returning = false;
            isChasing = false;
        }

        
    }
    
    public boolean lastMoveCollision(ArrayList<Wall> walls){
        
                 if ( lastMove.equals("-x")){
                     return collision(walls, x-.14f, y);
                }
                else if ( lastMove.equals("+x") ){
                    return collision(walls, x+.14f, y);
                }
                else if (lastMove.equals("-y") ){
                    return collision(walls, x, y-.14f);
                }
                else if (lastMove.equals("+y") ){
                    
                    return collision(walls, x, y+.14f);
                }
                else return false;
    }
    
    public void moveX(float c) {
        this.x += c;
    }
    
    public void moveY(float c) {
        this.y += c;
    }
    
    public Path[] getPath(ArrayList<Path> paths){
        Path[] currentPath = new Path[2];
        for (Path path : paths) {
            if (this.x >= path.getCorner1().getMinX() && this.x <= path.getCorner2().getMaxX() && this.y >= path.getCorner1().getMinY() && this.y <= path.getCorner2().getMaxY()){
                if (currentPath[0] == null)
                    currentPath[0] = path;
                else
                    currentPath[1] = path;
            }
        }
        return currentPath;
    }
    
    

    
}
