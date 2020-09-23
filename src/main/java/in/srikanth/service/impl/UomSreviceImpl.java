package in.srikanth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srikanth.exception.UomNotFoundException;
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

	@Override
	public void updateUom(Uom uom) {
		repo.save(uom);
	}

	@Override
	public void deleteUom(Integer id) {
		Uom uom = getOneUom(id);
		repo.delete(uom);
	}

	@Override
	public Uom getOneUom(Integer id) {
		Uom uom = repo.findById(id).orElseThrow(() -> new UomNotFoundException("Uom '" + id + "' Not exist"));
		return uom;
	}

	public boolean isUomModelExist(String uomModel) {
		/*
		 * boolean flag = true; Integer count = repo.getUomModelCount(uomModel);
		 * if(count==0) { flag = false; // not exist } else { flag = true; //exst }
		 * return flag;
		 */
		return repo.getUomModelCount(uomModel) > 0 ? true : false;
	}
}