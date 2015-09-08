package mapSmooth;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 
 * Created by yaoyao on 15/9/7.
 */
public class edgeSmooth {

    static int width = 0;
    static int height = 0;
    static int[][] map_4 = new int[128][256];
    static int[][] map = new int[256][256];

   /* public static void readMap2_1(String inputFile){

        File f = new File(inputFile);

        try{

            BufferedImage image = ImageIO.read(f);
            int type = image.getType();
            width = image.getWidth();
            height = image.getHeight();

            for(int i = 0 ; i < width/2; i=i+1)
            {
                for(int j=0;j<height;j = j+1)
                {
                    if(image.getRGB(2*i,j)== image.getRGB(2*i+1,j)){
                        map_4[i][j]=0;



                    }
                    else{
                        map_4[i][j]=1;
                        image.setRGB(2*i,j,12345);
                        image.setRGB(2*i+1,j,12345);

                    }
                }


            }


            ImageIO.write(image, "png", new File("/Users/yaoyao/IdeaProjects/mapSmooth/map/yy1.png"));
            System.out.println("@@@@@@@@@@");

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }*/

     /*use  the 2*2 mateix to  traverse  the image */
    public static void readMap2_2(String inputFile){

        File f = new File(inputFile);

        try{

            BufferedImage image = ImageIO.read(f);
            int type = image.getType();
            width = image.getWidth();
            height = image.getHeight();

            System.out.println("width:"+width+"##"+"height:"+height );

            for(int i = 0 ; i < width-1; i++)
            {
                for(int j=0;j<height-1; j++)
                {
                    if(image.getRGB(i,j)== image.getRGB(i+1,j)&&image.getRGB(i,j)== image.getRGB(i,j+1)){
                        map[i][j]=0;

                        System.out.println(i+"##"+j);


                    }
                    else{
                        map[i][j]=1;

                    }
                }


            }

            for(int m = 0 ; m < width ; m = m+1)
            {
                for(int n = 0 ; n < height ; n = n+1)
                {
                    if(map[m][n] == 1)
                        image.setRGB(m,n,12345);
                }
            }


            ImageIO.write(image, "png", new File("/Users/yaoyao/IdeaProjects/mapSmooth/map/yy1.png"));
            System.out.println("@@@@@@@@@@");

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }


}
