package com.SnapAirLines.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/s1")
public class adminController {
	@Autowired
	adminServices __services;

	@PostMapping("/createAirLines")
	@ResponseBody
	public ResponseEntity<String> createAirLines(@RequestBody List<airLines> airLines) throws Exception {
		return new ResponseEntity<String>(__services.executeAirLines(airLines), HttpStatus.OK);
	}

	@GetMapping("/airLines/list/{pageSkip}/{pageFetch}")
	@ResponseBody
	public ResponseEntity<Page<airLines>> getAllAirLines(@PathVariable(value = "pageSkip") Integer pageSkip,
			@PathVariable(value = "pageFetch") Integer pageFetch) {
		Page<airLines> airLines = null;
		try {
			airLines = __services.executeListAirLines(pageSkip, pageFetch);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Page<airLines>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<airLines>>(airLines, HttpStatus.OK);

	}

	@GetMapping("/airLines/list/{airLinesName}")
	@ResponseBody
	public ResponseEntity<List<Object[]>> getListAirLinesNames(
			@PathVariable(value = "airLinesName") String airLinesName, @RequestParam String airLinesAddress) {
		List<Object[]> airLines = null;
		try {
			airLines = __services.executeListAirLinesByNames(airLinesName, airLinesAddress);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Object[]>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object[]>>(airLines, HttpStatus.OK);

	}

	@DeleteMapping("/delete/airLines")
	@ResponseBody
	public ResponseEntity<String> deleteAirLines(@RequestParam String names, @RequestParam String id) {
		String result = null;
		try {
			System.out.println("inside the controller");
			result = __services.executeDeleteAirLines(names, id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/cat/create")
	@ResponseBody
	public ResponseEntity<Object> createCatAirLines(@RequestBody List<Cat_airlines> cat_airlines) {
		String result = null;
		if (cat_airlines.isEmpty()) {
			return new ResponseEntity<Object>("List cann't be null", HttpStatus.BAD_REQUEST);
		} else {
			result = __services.executeCatAirLnes(cat_airlines);
		}
		return new ResponseEntity<Object>(result, HttpStatus.OK);

	}

	@GetMapping("/cat/list/{pageOffset}/{pageFetch}")
	@ResponseBody
	public ResponseEntity<Page<Cat_airlines>> getListOfCat(@PathVariable(value = "pageOffset") Integer pageOffset,
			@PathVariable(value = "pageFetch") Integer pageFetch) {
		Page<Cat_airlines> cat_airlines = null;
		cat_airlines = __services.executeListCat(pageOffset, pageFetch);
		return new ResponseEntity<Page<Cat_airlines>>(cat_airlines, HttpStatus.OK);
	}

	@GetMapping("/list/cat/airLines")
	@ResponseBody
	public ResponseEntity<List<CatAirLinesModel>> getCatAirLines() {
		List<CatAirLinesModel> list = null;
		list = __services.executeCatAirDetails();
		return new ResponseEntity<List<CatAirLinesModel>>(list, HttpStatus.OK);
	}

}
