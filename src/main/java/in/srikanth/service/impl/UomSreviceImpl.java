package in.srikanth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srikanth.model.Uom;
import in.srikanth.repo.UomRepository;
import in.srikanth.service.IUomService;

@Service
public class UomSreviceImpl implements IUomService {

	@Autowired
	private UomRepository repo;

	@Override
	public Integer saveUom(Uom uom) {
		uom = repo.save(uom);
		return uom.getId();
	}

	@Override
	public List<Uom> getAllUoms() {
		return repo.findAll();
	}

}
