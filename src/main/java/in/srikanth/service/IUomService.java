package in.srikanth.service;

import java.util.List;

import in.srikanth.model.Uom;

public interface IUomService {

	public Integer saveUom(Uom uom);

	public List<Uom> getAllUoms();

	public void updateUom(Uom uom);

	public void deleteUom(Integer id);

	public Uom getOneUom(Integer id);

	public boolean isUomModelExist(String uomModel);

	public List<Object[]> getUomTypeAndCount();
}