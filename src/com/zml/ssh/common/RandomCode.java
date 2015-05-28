package com.zml.ssh.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该方法主要是生成验证码,并返4位回验证码 
 * 
 * @author Jason *
 */
public final class RandomCode {

	/**
	 * 经常用到的作静态常量处理，这样会加快处理速度，减少变量第次都要生成的内存空间浪费，用final使程序不用录找该类是否被继承，减少加载时间
	 * 
	 */

	private static final Random random = new Random();

	// 预定义定义四种字体，并将随机得到
	private static final Font[] CODEFONT = { new Font("Courier New", Font.BOLD, 20),
			new Font("宋体", Font.BOLD, 20)};

	// 预定义定义字体颜色，并将随机得到色
	private static final Color[] FONTCOLOR = { new Color(255,160,122), new Color(178,34,34), new Color(0,238,144),new Color(146,14,196) };

	// 预定义 图片的背景颜色，并将随机得到
	private static final Color[] BGCOLOR = {  Color.red, new Color(236,245,217) };

	// 预定义干扰线的颜色
	private static final Color LINECOLOR = new Color(176,223,229);

	// 预定义生随机的字符，用数组取值比String类型取一个值快
	private static final String[] CODE = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9","A","B","C","D","E","F","G","H","I","J","K","M","L","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","m","l","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	//private static final String[] CODE = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	// 返回的验证码
	private static StringBuffer CONDENUMBER = null;

	// 预定义图片大小
	private static final int WIDTH = 70, HEIGHT = 30;

	/**
	 * 生成验证码输出，并输出
	 * 
	 * @param request
	 * @param response
	 * @return codeNumber
	 */
	public final String image(HttpServletRequest request,
			HttpServletResponse response) {
		CONDENUMBER = new StringBuffer();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		//g.setColor(BGCOLOR[random.nextInt(2)]);
		g.setColor(BGCOLOR[1]);//对本项目取消黑色背景
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(new Color(255, 255, 255));  
		g.drawRect(0, 0, WIDTH - 1, HEIGHT - 1); //画边框
		
		for (int i = 0; i < 4; i++) {
			drawCode(g, i);
		}
		drawNoise(g, 15);
		g.setColor(new Color(210, 210, 210));
		g.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);
		g.dispose();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/png");
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			ImageIO.write(image, "png", sos);
			sos.flush();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return CONDENUMBER.toString();
	}

	/**
	 * 画验证码
	 * 
	 * @param request
	 * @param response
	 * @return void
	 */
	private final void drawCode(Graphics graphics, int i) {
		String number = CODE[random.nextInt(CODE.length)];
		graphics.setFont(CODEFONT[random.nextInt(CODEFONT.length)]);
		graphics.setColor(FONTCOLOR[i]);
	
		graphics.translate((int) (random.nextInt(35) * 3.14 / 180),0);
		
//		Graphics2D g2d_word=(Graphics2D)graphics;  
//		AffineTransform trans=new AffineTransform();  
	//	trans.rotate((45)*3.14/180,15*i+8,7);  
		/*缩放文字*/  
//		float scaleSize=random.nextFloat()+0.8f;  
//		if(scaleSize>1f) scaleSize=1f;  
//		trans.scale(scaleSize, scaleSize);  
//		g2d_word.setTransform(trans);  

		//设置字体间距、高度位置
		graphics.drawString(number, 8 + i * 15, 20);
		CONDENUMBER.append(number);
	}

	/**
	 * 画干扰线
	 * 
	 * @param graphics
	 * @param void
	 */
	private final void drawNoise(Graphics graphics, int lineNumber) {
		graphics.setColor(LINECOLOR);
		int pointX1, pointY1, pointX2, pointY2;
		for (int i = 0; i < lineNumber; i++) {
			pointX1 = 1 + (int) (Math.random() * WIDTH);
			pointY1 = 1 + (int) (Math.random() * HEIGHT);
			pointX2 = 1 + (int) (Math.random() * WIDTH);
			pointY2 = 1 + (int) (Math.random() * HEIGHT);
			graphics.drawLine(pointX1, pointY1, pointX2, pointY2);
		}
	}

}
