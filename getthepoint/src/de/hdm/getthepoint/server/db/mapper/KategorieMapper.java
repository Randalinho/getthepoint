package de.hdm.getthepoint.server.db.mapper;

import java.util.ArrayList;
import java.util.List;

import de.hdm.getthepoint.server.db.model.Kategorie;
import de.hdm.getthepoint.shared.bo.KategorieBo;

public class KategorieMapper implements
		DbMapperInterface<KategorieBo, Kategorie> {

	LehrenderMapper lehrenderMapper;

	public KategorieMapper() {
		lehrenderMapper = new LehrenderMapper();
	}

	@Override
	public List<KategorieBo> getModelsAsList(List<Kategorie> dbmodels) {
		List<KategorieBo> kategorien = new ArrayList<>();
		for (Kategorie kategorie : dbmodels) {
			kategorien.add(getModel(kategorie));
		}
		return kategorien;
	}

	@Override
	public KategorieBo getModel(Kategorie dbmodel) {
		KategorieBo kategorieBo = new KategorieBo();
		kategorieBo.setId(dbmodel.getId());
		kategorieBo.setBezeichnung(dbmodel.getBezeichnung());

		if (dbmodel.getLehrender() != null) {
			kategorieBo.setLehrender(lehrenderMapper.getModel(dbmodel
					.getLehrender()));
		}
		return kategorieBo;

	}

	@Override
	public Kategorie getDbModel(KategorieBo model) {
		Kategorie kategorie = new Kategorie();
		kategorie.setId(model.getId());
		kategorie.setBezeichnung(model.getBezeichnung());
		kategorie
				.setLehrender(lehrenderMapper.getDbModel(model.getLehrender()));

		return kategorie;
	}

}
