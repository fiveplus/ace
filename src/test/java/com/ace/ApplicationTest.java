package com.ace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment=WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

	@Test
	public void contextLoads() {
		int a = 100;
		while(a < 1000){
			int g = a%10;
			int s = a%100/10;
			int b = a%1000/100;
			if(g*g*g+s*s*s+b*b*b == a){
				System.out.println(a);
			}
			a++;
		}
	}

}
