package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entities.Info;
import com.repository.GenericRepository;

@Service("infoService")
@Transactional
public class InfoServiceImpl implements InfoService {

	@Autowired
	@Qualifier("com.repository.GenericRepository")
	private GenericRepository<Info> repository;

	@Override
	public void create(Info belonging) {
		this.repository.save(belonging);
	}

	@Override
	public void createMany(List<Info> list) {
	}

	@Override
	public List<Info> readAll() {
		return null;
	}

	@Override
	public void update(Info belonging) {

	}

	@Override
	public void delete(Info belonging) {

	}

}
