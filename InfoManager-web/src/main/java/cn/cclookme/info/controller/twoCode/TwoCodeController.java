package cn.cclookme.info.controller.twoCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.persistence.criteria.Root;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cclookme.info.util.LicenseImage;
import cn.cclookme.info.util.RootPath;


@Controller
@RequestMapping("/twocode")
public class TwoCodeController {
	private static final Logger log=Logger.getLogger(TwoCodeController.class);
	
	
	@RequestMapping(value="/getcode")
	public void imge(HttpServletRequest request,HttpServletResponse response) {
		//no image cache
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setContentType("image/jpeg");

				// use licenseImage calss 
				LicenseImage licenseImage = new LicenseImage();
				String path=RootPath.getRootPath();
				String imgpath=path+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"twocodeimage"+File.separator+"yzm9.png";
				Map<String, BufferedImage> licenseImg = licenseImage
						.createImage(imgpath);
						
				// get the value of map
				String key = licenseImg.keySet().iterator().next();
				request.getSession().setAttribute("twocode", key);
				// put the licenseImage key to session
				// SessionUtil.session(request).setAttribute(CommonConstant.LicenseImageKey,
				// key);
				//System.out.println("session中的验证码值为:" + key);
				
				// get image from map collection
				BufferedImage buffImg = licenseImg.get(key);
				ServletOutputStream out;
				try {
					out = response.getOutputStream();
					ImageIO.write(buffImg, "jpeg", out);
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
