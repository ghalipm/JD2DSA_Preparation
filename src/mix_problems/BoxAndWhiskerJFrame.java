package mix_problems;

import javax.swing.*;
import java.awt.*;

/**
 * @author ghalipm on 12/28/2023
 * @project JD2DSA_Preparation
 */
public class BoxAndWhiskerJFrame extends JFrame {

    // scale the box times of (10, 100 for smaller dataset; 1/10 if data set is large)
    //int scale=7;
    int scale=(DataExample.max>200 || DataExample.min>50)?5:7;

    // center of the box
    //int x0=((int)(Math.abs(DataExample.range)-Math.abs(DataExample.min))/scale)*scale, y0=20;
    int x0=((int)((DataExample.range)/scale)), y0=20;
    // center line height:
    //int clh=200;
    int clh=(int) (DataExample.range);

    public BoxAndWhiskerJFrame() {
        super("BoxAndWhiskerPlot");
        // set the box width - just long enough to cover the range of the data
        setSize(scale* (int)(DataExample.max+Math.abs(DataExample.min))+scale*Math.abs(x0), 2*clh);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
    }

    int q1=(int)Math.round(DataExample.quartile1);
    int q3=(int)Math.round(DataExample.quartile3);
    int q2=(int)Math.round(DataExample.quartile2);
    int iqr=q3-q1;
    int boxHeight=iqr*3/5;  // relative to the length of the box
    int leftWhisker=DataExample.lowerWhisker;
    int rightWhisker=DataExample.upperWhisker;


    public void paint(Graphics g) {
//        // set Color for the line
//        g.setColor(Color.green);
//        // draw and display the line - line length is 1000=1050-50 units
//        g.drawLine(50, 200, 1050, 200);

        // set Color for rectangle
        g.setColor(Color.blue);
        // draw a rectangle for box from q1 to q3:
        // q1=12, q2=23, q3=30, iqr=q1-q3

        g.drawRect(x0+scale*(int)(Math.abs(DataExample.min)+q1), clh-scale*boxHeight/2, scale*iqr, scale*boxHeight);
        // set Color for outliers
        g.setColor(Color.red);
        // draw right outlier
        int fontSize=14;
        //g.fillOval(960, 195, 10, 10);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        //g.drawString("+",960, 208);

        String outlierSymbol="+";
        String outlierLabel;

        //draw the right outlier
        while(DataExample.numOfRightOutliers > 0) {
            System.out.println("outliers = " + DataExample.outliers);
            outlierLabel=DataExample.outliers.get(DataExample.outliers.size() - 1).toString();
            int currentOutlier=DataExample.outliers.get(DataExample.outliers.size() - 1);

            g.drawString(outlierSymbol, (int) (Math.abs(DataExample.min)+currentOutlier) * scale +x0, clh-5);

            //g.drawString("72 ", (int) (StatisticsExamples.range) * scale - x0, 225);
            g.drawString(outlierLabel, (int) (Math.abs(DataExample.min)+currentOutlier) * scale + x0, clh+15);
            //g.drawString(outlierLabel, (int) (StatisticsExamples.maximum+(StatisticsExamples.outliers)) * scale + x0, 225);
            DataExample.outliers.remove(DataExample.outliers.size() - 1);
            DataExample.numOfRightOutliers--;
        }

        //draw the left outlier
        while(DataExample.numOfLeftOutliers > 0) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            //g.drawString("+",70, 208);
            System.out.println("outliers = " + DataExample.outliers);
            //outlierLabel=StatisticsExamples.outliers.get(0).toString();
            int currentOutlier=DataExample.outliers.get(0);
            System.out.println("currentOutlier = " + currentOutlier);
            outlierLabel=currentOutlier+"";

            //g.drawString(outlierSymbol, (int) (StatisticsExamples.min) * scale +x0, 208);
            g.drawString(outlierSymbol, (int) (Math.abs(DataExample.min)+currentOutlier)*scale+x0, clh+5);

            g.drawString(outlierLabel, (int) (Math.abs(DataExample.min)+currentOutlier) * scale + x0, clh+20);
            //g.drawString(outlierLabel, (int) (StatisticsExamples.maximum(StatisticsExamples.outliers)) * scale + x0, 225);
            DataExample.outliers.remove(0);
            DataExample.numOfLeftOutliers--;

        }


        // set Color for whisker
        g.setColor(Color.black);
        // draw left whisker
        //g.drawLine(270, 185, 270, 215);
        g.drawLine(scale*(int)(Math.abs(DataExample.min)+leftWhisker)+x0, clh-15, scale*(int)(Math.abs(DataExample.min)+leftWhisker)+x0, clh+15);


        // dashed line whisker to q1 (look at below):
        //g.drawLine(270, 200, 370, 200);

        // draw right whisker
        //g.drawLine(600, 185, 600, 215);
        g.drawLine(scale*(int)(Math.abs(DataExample.min)+rightWhisker)+x0, clh-15, scale*(int)(Math.abs(DataExample.min)+rightWhisker)+x0, clh+15);
        //draw the median
        g.setColor(Color.red);
        //g.drawLine(x0+scale*(q2), y0+scale*boxHeight, x0+scale*q2, y0+2*scale*boxHeight);// height is 100, same as the height of the box
        //g.drawLine(x0+scale*(int)(StatisticsExamples.range-StatisticsExamples.max+q2), y0+scale*boxHeight, x0+scale*(int)(StatisticsExamples.range-StatisticsExamples.max+q2), y0+2*scale*boxHeight);// height is 100, same as the height of the box
        g.drawLine(scale*(int)(Math.abs(DataExample.min)+q2)+x0, clh-scale*boxHeight/2, scale*(int)(Math.abs(DataExample.min)+q2)+x0, clh+scale*boxHeight/2);// height is 100, same as the height of the box

        System.out.println("(Math.abs(DataExample.min)) = " + ( (Math.abs(DataExample.min))));

        System.out.println("(x0+scale*(int)(Math.abs(DataExample.min)+q2)) = " + (x0 + scale * (int) (Math.abs(DataExample.min) + q2)));
//        // mark left end point on the line
//        g.setColor(Color.black);
//        //g.drawRect(50, 195, 2, 10);
//        g.drawRect((int)(DataExample.min-5)*scale, clh-5, 2, 10);
//        //g.drawString("-20", 40, 220);
//
//        // mark right end point on the line
//        //g.drawRect(1050, 195, 2, 10);
//        g.drawRect(x0+scale*(int)(DataExample.max+10), clh-5, 2, 10);
//        //g.drawString("80", 1040, 220);

        //label the box
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Box and Whisker Plot", 400, 70);

        //drawing dashed line:
        Graphics2D g2d = (Graphics2D) g;

        float[] dash1 = { 4f, 0f, 2f };
        float[] dash2 = { 2f, 0f, 2f };

        BasicStroke bs2 = new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash2,
                2f);
        g2d.setStroke(bs2);
        g2d.setColor(Color.yellow);
        //g2d.drawLine(50, 200, 1050, 200);
        g2d.drawLine(0, clh, x0+scale*(int)(DataExample.range), clh);

        BasicStroke bs1 = new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                2.0f,
                dash1,
                1f);

        g2d.setStroke(bs1);
        g2d.setColor(Color.black);
        // dashed line from the left whisker -  to q1:
        g2d.drawLine(x0+(int)(Math.abs(DataExample.min)+leftWhisker)*scale, clh, x0+(int)(Math.abs(DataExample.min)+q1)*scale, clh);
        // dashed line from q3 - to the right whisker:
        g2d.drawLine(scale*(int)(Math.abs(DataExample.min)+q3)+x0, clh, scale*(int)(Math.abs(DataExample.min)+rightWhisker)+x0, clh);
    }



    public static void main(String[] args) {
        new BoxAndWhiskerJFrame();
    }
}
