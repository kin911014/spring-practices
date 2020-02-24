package com.douzone.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> findAll() {
		List<GuestbookVo> serviceList = guestbookRepository.findAll();
		return serviceList;
	}

	public void insert(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		
	}

	public void delete(Long no, String password) {
		guestbookRepository.delete(no, password);
		
	}

}
