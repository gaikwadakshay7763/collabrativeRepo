package com.example.controller;

import com.example.csvpackage.ServiceForCsv;
import com.example.pojo.AuthorizeRequestPayload;
import com.example.pojo.Response;
import com.example.util.MyLogger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8083")
public class FileController {
    private static final String UPLOAD_DIR = "C:\\Users\\akshaygaik\\Desktop\\AkshayData\\movie\\src\\main\\resources";
    @Autowired
    MyLogger logger;

    @Autowired
    private ServiceForCsv serviceForCsv;

    @PostMapping("/CsvFile")
    public String downloadFile(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            logger.warn("File is empty");
            return "Failed to download file";
        }

        try {
            // Ensure the upload directory exists
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                logger.info("File is getting stored at the specified location");
                uploadDir.mkdirs();
            }

            // Get the file's original filename
            String originalFilename = file.getOriginalFilename();
            File destinationFile = new File(UPLOAD_DIR + originalFilename);

            // Save the file to the specified location
            file.transferTo(destinationFile);

            logger.info("File is stored successfully in the specified location");

            return "File uploaded successfully: " + originalFilename;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }

    }

    @PostMapping("/testJson")
    public ResponseEntity<?> testMappingObject(@RequestBody AuthorizeRequestPayload authorizeRequestBase) {

        System.out.println("Received AuthorizeRequestBase: " + authorizeRequestBase);

        String jsonPayload = "{" +
                "\"authorizeRequestBase\": {" +
                "\"header\": {" +
                "\"requestId\": \"0a54d200-ca6e-4a70-9ebe-8fb2d2bb5937\"," +
                "\"references\": {" +
                "\"paymentPlatform\": \"WOPA\"," +
                "\"transactionId\": \"12248562142\"" +
                "}" +
                "}," +
                "\"merchant\": {" +
                "\"merchantIdentification\": \"522591303\"," +
                "\"merchantCategoryCode\": \"5312\"," +
                "\"address\": {" +
                "\"addrLine1\": \"Address11\"," +
                "\"city\": \"Pune\"," +
                "\"country\": \"356\"," +
                "\"postCode\": \"PO4567\"" +
                "}," +
                "\"companyName\": \"SYSTEM TEST LEGAL ENTITY MID\"" +
                "}," +
                "\"card\": {" +
                "\"brand\": \"VISA\"," +
                "\"pan\": \"(16x)\"," +
                "\"entryMode\": {" +
                "\"fallbackindicator\": false," +
                "\"entryMode\": \"Keyed\"" +
                "}," +
                "\"cvcPresence\": \"NotProvidedBypass\"," +
                "\"expiryDate\": {" +
                "\"year\": \"(4x)\"," +
                "\"month\": \"(1x)\"" +
                "}," +
                "\"isPresent\": false" +
                "}," +
                "\"cardHolder\": {" +
                "\"verifyMethod\": \"None\"," +
                "\"isPresent\": false" +
                "}," +
                "\"transaction\": {" +
                "\"transTime\": \"2024-05-15T09:23:43.516+02:00\"," +
                "\"localDateTime\": \"2024-05-15T09:23:43.516+02:00\"," +
                "\"onlineReason\": \"AlwaysOnline\"," +
                "\"attemptCounter\": 1," +
                "\"fraudSuspected\": false," +
                "\"amount\": {" +
                "\"currency\": \"PEN\"," +
                "\"amount\": 49.4" +
                "}," +
                "\"transactionRef\": \"12248562142\"," +
                "\"acceptorReference\": \"12248562142\"," +
                "\"dccRequested\": false," +
                "\"chargeBackEligibility\": false," +
                "\"parRequested\": true" +
                "}," +
                "\"order\": {" +
                "\"orderId\": \"Order-2024051512515172\"," +
                "\"origin\": \"Ecommerce\"" +
                "}," +
                "\"poi\": {" +
                "\"terminalIds\": [" +
                "\"0\"" +
                "]," +
                "\"country\": \"604\"," +
                "\"terminalCapabilities\": {" +
                "\"magstripeEntry\": false," +
                "\"pkeEntry\": false," +
                "\"emvEntry\": false," +
                "\"contactlessEntry\": false," +
                "\"cvmPin\": false," +
                "\"cvmSignature\": false" +
                "}" +
                "}," +
                "\"originalTransaction\": {" +
                "\"cvcAddressResult\": {" +
                "\"postCode\": \"NotProvided\"," +
                "\"address\": \"NotProvided\"," +
                "\"cvc\": \"(11x)\"" +
                "}," +
                "\"approvalStatus\": \"Approved\"," +
                "\"responseDetails\": {" +
                "\"authorizationEntity\": \"Acquirer\"," +
                "\"transTime\": \"2024-05-15T07:21:58.2Z\"," +
                "\"approvedAmount\": {" +
                "\"currency\": \"PEN\"," +
                "\"amount\": 49.4" +
                "}," +
                "\"transactionReferenceSent\": \"12248562142\"," +
                "\"acceptorReferenceUsed\": \"12248562142\"," +
                "\"terminalUsed\": \"0\"," +
                "\"captureRequired\": true," +
                "\"authType\": \"Payment\"," +
                "\"specificAcquirerData\": {}" +
                "}," +
                "\"selectedInstallment\": {" +
                "\"selectedChoice\": \"PayInFull\"" +
                "}" +
                "}," +
                "\"authType\": \"Refund\"" +
                "}," +
                "\"maxWaitTime\": 300" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        File getFile = null;
        try {
            AuthorizeRequestPayload authorizeRequestBases = objectMapper.readValue(jsonPayload, AuthorizeRequestPayload.class);
            System.out.println(authorizeRequestBases);
            JsonNode jason = objectMapper.convertValue(authorizeRequestBases,JsonNode.class);

            // getFile = serviceForCsv.jsonToCsv(jason);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject("http://localhost:8083/jsonToCsv",authorizeRequestBase,AuthorizeRequestPayload.class);
        
      
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/jsonToCsv")
    public String createFile(@RequestBody Response payload) throws IOException {


           // Response authorizeRequestBases1 = objectMapper.readValue(payload.toString(), Response.class);
            JsonNode jason = objectMapper.convertValue(payload,JsonNode.class);
             serviceForCsv.jsonToCsv(jason);

            return "File is created";



    }


    @PostMapping("/CsvFiles")
    public ResponseEntity<?> downloadFiles(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            File files = File.createTempFile("temp", ".csv");
            file.transferTo(files);
            List<AuthorizeRequestPayload> requests = serviceForCsv.processCsvFile(files);

            return new ResponseEntity<>(requests, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("file is empty",HttpStatus.BAD_REQUEST);
        }
    }
}
