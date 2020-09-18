package in.srikanth.service;

import java.util.List;
 
import in.srikanth.model.WhUserType;

public interface IWhUserType {
	
	public Integer saveWhUserType(WhUserType whusertype);

	List<WhUserType> getAllWhUserTypes();

}