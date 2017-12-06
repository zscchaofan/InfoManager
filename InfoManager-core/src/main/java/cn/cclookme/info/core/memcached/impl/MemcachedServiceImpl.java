package cn.cclookme.info.core.memcached.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.cclookme.info.api.memcached.service.MemcachedService;

import com.danga.MemCached.MemCachedClient;

@Service("memcachedservice")
public class MemcachedServiceImpl implements MemcachedService {
	private static final Logger logger = Logger
			.getLogger(MemcachedServiceImpl.class);

	private static MemCachedClient cachedClient;
	static{
		if(cachedClient==null){
			cachedClient=new MemCachedClient("memcachedPool");
		}
	}
	
	@Override
	public boolean set(String key, Object value) {
		return setExp(key, value, null);
	}

	@Override
	public boolean set(String key, Object value, Date expire) {
		return setExp(key, value, expire);
	}

	@Override
	public boolean setExp(String key, Object value, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.set(key, value, expire);
		} catch (Exception e) {
			// 记录Memcached日志
		}
		return flag;
	}

	@Override
	public boolean addForeverObject(String key, Object value) {
		boolean flag = false;
		try {
			flag = cachedClient.set(key, value, 0);
		} catch (Exception e) {
			// 记录Memcached日志
		}
		return flag;
	}

	@Override
	public boolean add(String key, Object value) {
		return addExp(key, value, null);
	}

	@Override
	public boolean add(String key, Object value, Date expire) {
		return addExp(key, value, expire);
	}

	@Override
	public boolean addExp(String key, Object value, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.add(key, value, expire);
		} catch (Exception e) {
			// 记录Memcached日志
		}
		return flag;
	}

	@Override
	public boolean replace(String key, Object value) {
		return replaceExp(key, value, null);
	}

	@Override
	public boolean replace(String key, Object value, Date expire) {
		return replaceExp(key, value, expire);
	}

	@Override
	public boolean replaceExp(String key, Object value, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.replace(key, value, expire);
		} catch (Exception e) {
		}
		return flag;
	}

	@Override
	public Object get(String key) {
		Object obj = null;
		try {
			obj = cachedClient.get(key);
		} catch (Exception e) {
		}
		return obj;
	}

	@Override
	public boolean delete(String key) {
		return deleteExp(key, null);
	}

	@Override
	public boolean delete(String key, Date expire) {
		return deleteExp(key, expire);
	}

	@Override
	public boolean deleteExp(String key, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.delete(key, expire);
		} catch (Exception e) {
		}
		return flag;
	}

	@Override
	public boolean flashAll() {
		boolean flag = false;
		try {
			flag = cachedClient.flushAll();
		} catch (Exception e) {
		}
		return flag;
	}

}
