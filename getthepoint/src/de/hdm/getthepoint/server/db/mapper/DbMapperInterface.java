package de.hdm.getthepoint.server.db.mapper;

import java.util.List;

import de.hdm.getthepoint.shared.bo.BusinessObject;

public interface DbMapperInterface<Model extends BusinessObject, DbModel> {

	public List<Model> getModelsAsList(List<DbModel> dbmodels);

	public Model getModel(DbModel dbmodel);

	public DbModel getDbModel(Model model);

}
