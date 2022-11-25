package com.SnapAirLines.demo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class adminServices {
	@Autowired
	adminDao _adminActionDao;
	@Autowired
	catAdminDao _catAdminDao;

	public String executeAirLines(List<airLines> airLines) throws Exception {
		_adminActionDao.saveAll(airLines);
		return "true";
	}

	public Page<airLines> executeListAirLines(Integer pageSkip, Integer pageFetch) {
		Pageable paging = PageRequest.of(pageSkip, pageFetch, Sort.by("creationDate").descending());
		return (Page<airLines>) _adminActionDao.findAll(paging);
	}

	public List<Object[]> executeListAirLinesByNames(String airLinesName, String airLinesAddress) {
		return (List<Object[]>) _adminActionDao.findByAirLines(airLinesName, airLinesAddress);
		// return (List<Object[]>) _adminActionDao.findByDetailAirLines();
	}

	public String executeDeleteAirLines(String names, String id) {
		_adminActionDao.deleteAirLines(names, id);
		return "true";
	}

	public String executeCatAirLnes(List<Cat_airlines> cat_airlines) {
		System.out.println("count of list" + cat_airlines.size());
		_catAdminDao.saveAll(cat_airlines);
		return "true";
	}

	public Page<Cat_airlines> executeListCat(Integer pageOffset, Integer pageFetch) {
		Pageable paging = PageRequest.of(pageOffset, pageFetch, Sort.by("id").descending());
		return _catAdminDao.findAll(paging);
	}

	public List<CatAirLinesModel> executeCatAirDetails() {
		List<CatAirLinesModel> list = new LinkedList<CatAirLinesModel>();
		List<Object[]> result = _adminActionDao.findByCatServices();

		for (Object[] obj : result) {
			CatAirLinesModel model = new CatAirLinesModel();
			model.setAirId((Integer) obj[0]);
			model.setOwner((String) obj[1]);
			model.setNames((String) obj[2]);
			model.setTypes((String) obj[3]);
			list.add(model);
		}
		return list;
	}

}