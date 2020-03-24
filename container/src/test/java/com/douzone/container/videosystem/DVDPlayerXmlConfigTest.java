package com.douzone.container.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {

	@Rule
	public final SystemOutRule systemOutRule= new SystemOutRule().enableLog();
	
	@Autowired
	DigitalVideoDisc dvd;
	
	@Test
	public void testDvdNotNull() {
		assertNotNull(dvd);
	}
}
