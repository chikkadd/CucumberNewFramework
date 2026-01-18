package com.screenshots;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ScreenshotHelper {
	
	public static final ThreadLocal<Map<String, Object>> SCREEN_SHOTS = new ThreadLocal<>() {
		 @Override
	        protected Map<String, Object> initialValue() {
	            return new HashMap<>();
	        }
	    };
	    
	public static void add(String name, byte[] image )
	{
		SCREEN_SHOTS.get().put(name, image);
	}
	public static Map<String, Object> getScreenShotsForCurrentTest()
	{
		return SCREEN_SHOTS.get();
	}
	public static void tidyAfterRun()
	{
		SCREEN_SHOTS.remove();
	}
	public static byte[] imageToByteArray(BufferedImage image) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", stream);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return stream.toByteArray();
    }

}
