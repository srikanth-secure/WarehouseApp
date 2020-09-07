package in.srikanth.service;

import java.util.List;

import in.srikanth.model.Uom;

public interface IUomService {
	public Integer saveUom(Uom uom);
	public List<Uom> getAllUoms();
}
