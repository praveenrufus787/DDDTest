package com.wirecard.NTLTaxi.reportsgeneration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.wirecard.NTLTaxi.initializer.Initiatizer;

public class ReportOptimizer extends Initiatizer{
@Test
	public static void archiveFiles() throws Throwable
	{
	if(isarchive)
	{
		
	
	SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH-mm-SS-mmm");
    String data=	sf.format(new Date());
    System.out.println(data);
	
		File src = new File("C:\\workspace\\DDDTest\\screenshot");
		File des = new File("C:\\workspace\\DDDTest\\archive\\Old" +data);
		FileUtils.copyDirectory(src, des);
		FileUtils.cleanDirectory(src);
		isarchive= false;
	}
	}
}
