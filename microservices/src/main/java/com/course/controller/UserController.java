package com.course.controller;

import com.course.model.User;
//import com.course.service.AccessPropertiesFromFile;
import com.course.service.UserService;
import com.course.utile.userNotFoundException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;


@RestController
public class UserController {

    @Autowired
    UserService userService;
  // private AccessPropertiesFromFile accessPropertiesFromFile;

    private MessageSource messageSource;
    private Object String;

    public UserController(){};
    public UserController(UserService userService) {
        this.userService = userService;

    }

//    public UserController(AccessPropertiesFromFile accessPropertiesFromFile) {
//        this.accessPropertiesFromFile = accessPropertiesFromFile;
//
//    }


//    @GetMapping("/allUser")
//    ResponseEntity<List<User>> getAllUser(){
//        List<User> users =  userService.getAllUser();
//        accessPropertiesFromFile.planCode("2");
//        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
//    }

//    @GetMapping("/getUser/{id}")
//    public EntityModel<User> getUser(@PathVariable("id") int id){
//
//
//        User user =  userService.getUser(id);
//        if(user == null)
//        	throw new userNotFoundException("id:"+id);
//            EntityModel<User> entityModel = EntityModel.of(user);
//
//            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUser());
//
//            entityModel.add(link.withRel("All-users"));
//
//        return entityModel;
//            }

    @PostMapping(path ="/registerUser")
    String registerUserHeaders(@RequestBody User user){
    	
    	User registerUser =userService.registerUser(user);
    	
    	URI locationUri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(registerUser.getUserId()).toUri();

            try {
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                String xml = xmlMapper.writeValueAsString(user);


                if(xml.contains("<taxes>")){
                    xml = xml.replaceFirst("<taxes>","<Taxes soapenc:arrayType=\"ws:TaxStruct[]\">");
                }


                String envelopeStart = "<?xml version=\"1.1\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">  <soap:Body>    <" +
                         ">";
                String envelopeEnd = "</"  + ">  </soap:Body></soap:Envelope>";
                final String soapMessage = envelopeStart + xml + envelopeEnd;
                return soapMessage;
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error while creating xml " + e);
            }

    	
    }

    @PostMapping(path ="/registerUser", headers = "version2")
    ResponseEntity<User>                                                            registerUser(@Validated @RequestBody User user){

        User registerUser =userService.registerUser(user);

        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(registerUser.getUserId()).toUri();


        return ResponseEntity.created(locationUri).build();

    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserbyId(@PathVariable("id") int id){
    	

         userService.deletUser(id);
        


    }
    @GetMapping(value="/globalization")
    public String globalization(){
    Locale locale = LocaleContextHolder.getLocale();
    //Not getting the desired message.default messege is working here.
        return messageSource.getMessage("good.morning.message",null,"default message",locale);
    }

    @GetMapping("/filtering/{id}")
    public MappingJacksonValue filtering(@PathVariable("id") int id){

        User user = userService.getUser(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);

        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("birthday","userName");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
        mappingJacksonValue.setFilters(filters);
            return mappingJacksonValue;

    }
    @GetMapping("/filteringList")
    public MappingJacksonValue filteringList(){
        List<User> list = userService.getAllUser();



        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("birthday", "userName");

        SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserFilter", filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }


}

