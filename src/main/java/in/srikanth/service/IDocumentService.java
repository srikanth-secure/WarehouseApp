package in.srikanth.service;

import java.util.List;
import java.util.Optional;

import in.srikanth.model.Document;

public interface IDocumentService {

	void saveDocument(Document document);

	List<Object[]> getDocumentIdAndNames();

	Optional<Document> getOneDocument(Integer id);

	public void deleteDocument(Integer id);

}