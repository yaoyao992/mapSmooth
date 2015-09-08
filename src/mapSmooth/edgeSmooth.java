package mapSmooth;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by yaoyao on 15/9/7.
 */
public class edgeSmooth {

    static int width = 0;
    static int height = 0;
    static int[][] map_4 = new int[128][128];

    public static void readMap(String inputFile){

        File f = new File(inputFile);

        try{

            BufferedImage image = ImageIO.read(f);
            int type = image.getType();
            width = image.getWidth();
            height = image.getHeight();

            for(int i = 0 ; i < width/2; i=i+1)
            {
                for(int j=0;j<height/2;j = j+1)
                {
                    if(image.getRGB(2*i,2*j)== image.getRGB(2*i+1,2*j)&&image.getRGB(2*i,2*j)== image.getRGB(2*i,2*j+1)&&image.getRGB(2*i,2*j)== image.getRGB(2*i+1,2*j+1)){
                        map_4[i][j]=0;



                    }
                    else{
                        map_4[i][j]=1;
                        image.setRGB(2*i,2*j,12345);
                        image.setRGB(2*i+1,2*j,12345);
                        image.setRGB(2*i,2*j+1,12345);
                        image.setRGB(2*i+1,2*j+1,12345);
                    }
                }


            }


            ImageIO.write(image, "png", new File("/Users/yaoyao/IdeaProjects/mapSmooth/map/yy1.png"));
            System.out.println("@@@@@@@@@@@@@@");

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
