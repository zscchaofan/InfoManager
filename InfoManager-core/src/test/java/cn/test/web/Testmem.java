package cn.test.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.cclookme.info.util.MemcachedUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-memcached.xml")
public class Testmem {

		@Test
		public void testInsert() {
			MemcachedUtil.add("xxx", "11");
		}

		@Test
		public void testGet() {
			String str = (String) MemcachedUtil.get("xxx");
			System.out.println("输出：" + str);
		}
}
