package in.srikanth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srikanth.model.Uom;
import in.srikanth.model.WhUserType;
import in.srikanth.repo.WhUserTypeRepository;
import in.srikanth.service.IWhUserType;

@Service
public class WhUserTypeServiceImpl implements IWhUserType {

	@Autowired
	private WhUserTypeRepository repo;
	
	@Override
	public Integer saveWhUserType(WhUserType whusertype) {
		whusertype=repo.save(whusertype);
		return whusertype.getId();
	}
	
	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return repo.findAll();
	}
}
