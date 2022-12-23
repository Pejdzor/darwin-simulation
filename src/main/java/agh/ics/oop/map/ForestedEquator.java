package agh.ics.oop.map;

import agh.ics.oop.Grass;
import agh.ics.oop.Vector2d;

import java.util.*;

public class ForestedEquator extends GrassGenerator{
    private Vector2d prefLowLeft;
    private Vector2d prefTopRight;
    public ForestedEquator(int width, int height, int grassToGenerate, Map<Vector2d, Grass> presentGrass){
        this.width=width;
        this.height=height;
        this.plants=grassToGenerate;
        this.coords=presentGrass.keySet().stream().toList();
        getPreferedArea(width,height);
    }
    private void getPreferedArea(int width,int height){
        int area=(int) (width*height*0.2);
        int h=area/width;
        this.prefTopRight=new Vector2d(width-1,height/2+h/2-1);
        this.prefLowLeft=new Vector2d(0,height/2-h/2);
        if (this.prefLowLeft.y>this.prefTopRight.y){
            this.prefTopRight=new Vector2d(prefTopRight.x, prefLowLeft.y);
        }

    }

    public Map<Vector2d,Grass> generateGrass(ArrayList<Vector2d> currentGrass, int grassnum){
        this.coords=currentGrass;
        int i=0,x,y;
        Random rn = new Random();
        Vector2d v;
        while (i<grassnum){

            x=rn.nextInt(0,this.width);
            y=rn.nextInt(0,this.height);
            v = new Vector2d(x,y);
            if (!currentGrass.contains(v)){
                currentGrass.add(v);
            }
            i++;

        }
        Map<Vector2d,Grass> map= new HashMap<>();
        for (Vector2d vector:currentGrass){
            map.put(vector,new Grass());
        }
        return map;


    }
}
