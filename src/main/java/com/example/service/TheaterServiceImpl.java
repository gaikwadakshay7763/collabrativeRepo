package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.dto.TheaterDto;
import com.example.mappers.TheaterMapper;
import com.example.util.MyLogger;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Theater;
import com.example.repository.TheaterRepo;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	 TheaterRepo theaterRepo;
	@Autowired
	TheaterMapper theaterMapper;
	@Autowired
	MyLogger logger;
	




	public List<TheaterDto> getAllTheater() {
		List<Theater> theaters = theaterRepo.findAll();
		logger.info("list  of all theater ");
		return theaters.stream().map(theaterMapper::toDto).collect(Collectors.toList());
	}

	
	public Theater getTheaterById(int id) {
		Theater result = theaterRepo.getById(id);
		return result;
	}

	
//	public Theater getTheaterByName(String name) {
//		Theater theater = theaterRepo.findTheaterByName(name);
//		return theater;
//	}


	
	public Theater saveTheater(Theater theater) {
		Theater newTheater = theaterRepo.save(theater);
		logger.info1("theater save ",newTheater);

		String soapMessage = createSoapMessage(newTheater);
		return newTheater;
	}


	public String deleteAllTheater(){
		theaterRepo.deleteAll();
		return "successful";
	}

	private String createSoapMessage(Object obj) {
		try {
			XmlMapper xmlMapper = new XmlMapper();
			String xml = xmlMapper.writeValueAsString(obj);

			String envelopeStart = "<?xml version=\"1.1\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">  <soap:Body>    <"
					+ ">";
			String envelopeEnd = "</" +  ">  </soap:Body></soap:Envelope>";
			final String soapMessage = envelopeStart + xml + envelopeEnd;
			return soapMessage;
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error while creating xml " + e);
		}

	}



	private int privateMethod(int value) {
		// This private method performs some complex logic
		return value * value;
	}


}
