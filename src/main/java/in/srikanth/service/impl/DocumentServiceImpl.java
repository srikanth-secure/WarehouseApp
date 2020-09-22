package in.srikanth.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srikanth.model.Document;
import in.srikanth.model.ShipmentType;
import in.srikanth.repo.DocumentRepo;
import in.srikanth.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private DocumentRepo repo;

	@Override
	public void saveDocument(Document document) {
		repo.save(document);
	}

	@Override
	public List<Object[]> getDocumentIdAndNames() {
		return repo.getDocumentIdAndNames();
	}

	@Override
	public Optional<Document> getOneDocument(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void deleteDocument(Integer id) {
		Optional<Document> doc=getOneDocument(id);
		repo.deleteById(id);		
	}
}
