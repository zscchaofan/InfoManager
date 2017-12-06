package cn.cclookme.info.util;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;



/**
 * 类说明: 验证码工具
 *
 * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 
 *
 * org.pudp.util.license.LicenseImage.java
 *
 */

public class LicenseImage {
    
    public static final Integer TYPE1 = 1;        //样式一
    public static final Integer TYPE2 = 2;        //样式二
    public static final Integer TYPE3 = 3;        //样式三
    public static final Integer TYPE4 = 4;        //样式四
    
    public static final int DEF_NUM = 4;            //验证码上的字符个数
    public static final int DEF_LINES = 3;             //干扰线条数
    public static final int DEF_WIDTH = 150;        //验证码图片宽
    public static final int DEF_HEIGHT = 50;        //验证码图片高
    public static final int DEF_FONT_SIZE = 24;        //验证码上字体大小
        
    private int num;                    //验证码上的字符个数
    private int width ;                    //验证码图片宽
    private int height ;                //验证码图片高
    private int fontSize ;                //验证码上字体大小
    private int lines ;                    //干扰线条数
 
    
    private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
        "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I" };
    
    public LicenseImage(){
        this(DEF_WIDTH, DEF_HEIGHT, DEF_FONT_SIZE, DEF_NUM, DEF_LINES);
    }
    
    /**
     * 自定义验证码的宽度与高度
     * @param width
     *                     验证码的宽度
     * @param height
     *                     验证码的高度
     */
    public LicenseImage(int width,int height){
        if(width<0 || height<0){
            this.width = LicenseImage.DEF_WIDTH;
            this.height = LicenseImage.DEF_HEIGHT;
        }else{
            this.width = width;
            this.height = height;
        }
        this.num = LicenseImage.DEF_NUM;
        this.fontSize = LicenseImage.DEF_FONT_SIZE;
        this.lines = LicenseImage.DEF_LINES;
    }
    
    /**
     * 自定义验证码的宽度和高度,以及字体大小
     * @param width
     *                     验证码的宽度
     * @param height
     *                     验证码的高度
     * @param fontSize
     *                     验证码字体大小
     */
    public LicenseImage(int width,int height,int fontSize){
        this(width, height);
        this.fontSize = fontSize;
        this.num = LicenseImage.DEF_NUM;
        this.lines = LicenseImage.DEF_LINES;
    }
 
    /**
     * 自定义验证码的宽度和高度,以及字体大小
     * @param width
     *                     验证码的宽度
     * @param height
     *                     验证码的高度
     * @param fontSize
     *                     验证码字体大小
     * 
     * @param size
     *                     验证码上字体个数
     */
    public LicenseImage(int width,int height,int fontSize,int num){
        this(width, height,fontSize);
        if(num <0){
            this.num = LicenseImage.DEF_NUM;
        }else{
            this.num = num;
        }
    
        this.lines = LicenseImage.DEF_LINES;
    }
    
    /**
     * 自定义验证码的宽度和高度,以及字体大小
     * @param width
     *                     验证码的宽度
     * @param height
     *                     验证码的高度
     * @param fontSize
     *                     验证码字体大小
     * @param size
     *                     验证码上字体个数
     * 
     * @param lines
     *                     验证码上的干扰线条数目
     */
    
    public LicenseImage(int width,int height,int fontSize,int num,int lines){
        this(width, height,fontSize,num);
        this.lines = lines;
    }
 
    
    /**
     * 
     * 生成验证码,验证码图片由用户自己定义
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 下午08:13:53
     *                
     * @param backgroundPath
     *                     用户自定义的验证码的背景图片
     * @return
     *                     验证码生成后的封装对象
     */
    public Map<String,BufferedImage> createImage(String backgroundPath){
        //保存产生验证码真实值的串
        StringBuffer buffer = new StringBuffer();    
        //自定义图片对象
        BufferedImage image = new BufferedImage(this.width,this.height,BufferedImage.TYPE_INT_RGB);
        Map<String,BufferedImage> map = new HashMap<String,BufferedImage>();
        Graphics2D graphics = (Graphics2D) image.createGraphics();
        graphics.setColor(Color.WHITE);
        // 初始化背景图片
        try {
        	File file=new File(backgroundPath);
            Image bgImage = ImageIO.read(file);
            graphics.drawImage(bgImage,0,0,this.width,this.height,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Random random = new Random();
        //画随机字符
        for(int i=0; i<this.num; i++){
            //随即获取定义字符集中的一个元素
            int rand = random.nextInt(chars.length);
            graphics.setColor(randomColor());
            graphics.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,this.fontSize));
            /** **随机缩放文字并将文字旋转指定角度* start*/
            Graphics2D g2d_word = (Graphics2D) graphics;
            AffineTransform trans = new AffineTransform();
            trans.rotate(random.nextInt(10) * 3.14 / 90, 13 * i + 8, 7);
            // 缩放文字
            float scaleSize = random.nextFloat() +0.8f;
            if (scaleSize > 1f){
                scaleSize = 1f;
            }    
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            /** **随机缩放文字并将文字旋转指定角度* end*/
            graphics.drawString(chars[rand],(this.num*2)+(i)*this.width/this.num , this.height/2);
            buffer.append(chars[rand]); //将生成的字符串存入到buffer中,将来获取时用于跟用户输入的值比较
        }
        //画干扰线
        for(int i=1;i<=this.lines;i++){
            graphics.setColor(randomColor());
            graphics.drawLine(random.nextInt(this.width), random.nextInt(this.height),
                    random.nextInt(this.width),random.nextInt(this.height));
            if(i==this.lines){
                Font font = new Font("Times New Roman",Font.PLAIN, this.fontSize-5);
                graphics.setFont(font);
                graphics.setColor(Color.GRAY);
            }
        }
        //画一条折线        
        /*
        BasicStroke bs=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);    //创建一个供画笔选择线条粗细的对象
        graphics.setStroke(bs);                    //改变线条的粗细
        graphics.setColor(randomColor());        //设置当前颜色为预定义颜色中的深灰色
        int[] xPoints=new int[3];
        int[] yPoints=new int[3];
        for(int j=0;j<3;j++){
            xPoints[j]=random.nextInt(WIDTH - 1);
            yPoints[j]=random.nextInt(HEIGHT - 1);
        }
        graphics.drawPolyline(xPoints, yPoints,3);
        */
        map.put(buffer.toString(), image);
        return map;
    }
    
    
    /**
     * 
     * 使用系统默认样式
     * 
     * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 下午08:06:22
     *                
     * @param type
     *                 工具内置的类型,用户使用该类型即可用内置的样式生成验证码
     * @return
     *                 Map<验证码的值,验证码的图片>
     */
    public  Map<String,BufferedImage> createImage(int type){
        return createImage("org/pudp/util/license/resources/yzm"+type+".gif");
    }
    
    
    /**
     * 随即产生颜色
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 下午08:04:08
     *                
     * @return
     *            <code>Color对象</code>
     */
    public static Color randomColor(){
        Random random = new Random();
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        return color;
    }
    
}