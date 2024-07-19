package com.example.csvpackage;

import com.example.pojo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class ServiceForCsv {


    public List<AuthorizeRequestPayload> processCsvFile(File tempFile) throws IOException {
        List<Map<String, String>> csvData = readObjectsFromCsv(tempFile);
        return writeAsJson(csvData);
    }



        public  List<Map<String,String>> readObjectsFromCsv(File file) throws IOException {

            char separator = detectSeparator(file);
            CsvSchema bootstrap = CsvSchema.emptySchema().withHeader().withColumnSeparator(separator);
            CsvMapper csvMapper = new CsvMapper();
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
                try (MappingIterator<Map<String,String>> mappingIterator = csvMapper.readerFor(Map.class).with(bootstrap).readValues(reader)) {
                    return mappingIterator.readAll();
                }
            }

        }

        public List<AuthorizeRequestPayload> writeAsJson(List<Map<String,String>> data) throws IOException {

            List<AuthorizeRequestPayload> jsonList = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            Gson gson = new Gson();
            for (Map<String,String> map : data) {
                //creating objects of classes
                Address address = new Address();
                address.setAddrLine1( map.get("addrLine1"));
                address.setCity(map.get("city"));
                address.setCountry(map.get("country"));
                address.setPostCode(map.get("postCode"));


                Amount amount = new Amount();
                amount.setAmount(Double.parseDouble(map.get("amount")));
                amount.setCurrency(map.get("currency"));



                ApprovedAmount approvedAmount = new ApprovedAmount();
                approvedAmount.setAmount(Double.parseDouble(map.get("responseDetails_amount")));
                approvedAmount.setCurrency(map.get("responseDetails_currency"));



                CardHolder cardHolder = new CardHolder();
                cardHolder.setVerifyMethod(map.get("verifyMethod"));
                cardHolder.setPresent(Boolean.parseBoolean(map.get("cardHolder_isPresent")));


                CvcAddressResult cvcAddressResult = new CvcAddressResult();
                cvcAddressResult.setAddress(map.get("cvcAddressResult_address"));
                cvcAddressResult.setPostCode(map.get("cvcAddressResult_postCode"));
                cvcAddressResult.setCvc(map.get("cvc"));


                EntryMode entryMode = new EntryMode();
                entryMode.setFallbackindicator(Boolean.parseBoolean(map.get("fallbackindicator")));
                entryMode.setEntryMode(map.get("entryMode"));


                ExpiryDate expiryDate = new ExpiryDate();
                expiryDate.setYear(map.get("year"));
                expiryDate.setMonth(map.get("month"));

                Card card = new Card();
                card.setBrand(map.get("brand"));
                card.setPan( map.get("pan"));
                card.setCvcPresence(map.get("cvcPresence"));
                card.setPresent(Boolean.parseBoolean(map.get("isPresent")));
                card.setExpiryDate(expiryDate);
                card.setEntryMode(entryMode);



                MerchantInfo merchantInfo = new MerchantInfo();
                merchantInfo.setMerchantIdentification(map.get("merchantIdentification"));
                merchantInfo.setMerchantCategoryCode(map.get("merchantCategoryCode"));
                merchantInfo.setAddress(address);
               // merchantInfo.setCompanyName(map.get("companyName"));


                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrderId(map.get("orderId"));
                orderDetails.setOrigin(map.get("origin"));




                References references = new References();
                references.setTransactionId(map.get("transactionId"));
                references.setPaymentPlatform(map.get("paymentPlatform"));


                ResponseDetails responseDetails = new ResponseDetails();
                responseDetails.setApprovedAmount(approvedAmount);
                responseDetails.setAcceptorReferenceUsed(map.get("acceptorReferenceUsed"));
                responseDetails.setAuthorizationEntity(map.get("authorizationEntity"));
                responseDetails.setCaptureRequired(Boolean.parseBoolean(map.get("captureRequired")));
                responseDetails.setAuthType(map.get("responseDetails_authType"));
                responseDetails.setTerminalUsed(map.get("terminalUsed"));
                responseDetails.setTransTime(map.get("responseDetails_transTime"));

                String specificAcquirerDataJsonString = map.get("specificAcquirerData");
                Map<String, String> specificAcquirerDataMap = null;
                if (specificAcquirerDataJsonString != null && !specificAcquirerDataJsonString.isEmpty()) {
                    specificAcquirerDataMap = objectMapper.readValue(specificAcquirerDataJsonString, new TypeReference<Map<String, String>>() {});
                }
                responseDetails.setSpecificAcquirerData( specificAcquirerDataMap);

                responseDetails.setTransactionReferenceSent(map.get("transactionReferenceSent"));



                SelectedInstallment selectedInstallment = new SelectedInstallment();
                selectedInstallment.setSelectedChoice(map.get("selectedChoice"));

                TerminalCapabilities terminalCapabilities = new TerminalCapabilities();
                terminalCapabilities.setCvmPin(Boolean.parseBoolean(map.get("cvmPin")));
                terminalCapabilities.setContactlessEntry(Boolean.parseBoolean(map.get("contactlessEntry")));
                terminalCapabilities.setCvmSignature(Boolean.parseBoolean(map.get("cvmSignature")));
                terminalCapabilities.setEmvEntry(Boolean.parseBoolean(map.get("emvEntry")));
                terminalCapabilities.setMagstripeEntry(Boolean.parseBoolean(map.get("magstripeEntry")));
                terminalCapabilities.setPkeEntry(Boolean.parseBoolean(map.get("pkeEntry")));


                TransactionDetails transactionDetails = new TransactionDetails();
                transactionDetails.setTransactionRef(map.get("transactionRef"));
                transactionDetails.setAcceptorReference(map.get("acceptorReference"));
                transactionDetails.setAttemptCounter(Integer.parseInt(map.get("attemptCounter")));
                transactionDetails.setDccRequested(Boolean.parseBoolean(map.get("dccRequested")));
                transactionDetails.setFraudSuspected(Boolean.parseBoolean(map.get("fraudSuspected")));
                transactionDetails.setOnlineReason(map.get("onlineReason"));
                transactionDetails.setParRequested(Boolean.parseBoolean(map.get("parRequested")));
                transactionDetails.setLocalDateTime(map.get("localDateTime"));
                transactionDetails.setTransTime(map.get("transTime"));
                transactionDetails.setAmount(amount);
                transactionDetails.setChargeBackEligibility(Boolean.parseBoolean(map.get("chargeBackEligibility")));

                Poi poi = new Poi();
                poi.setCountry(map.get("poi_country"));
                poi.setTerminalCapabilities(terminalCapabilities);
                poi.setTerminalIds(Collections.singletonList(map.get("terminalIds")));


                OriginalTransaction originalTransaction = new OriginalTransaction();
                originalTransaction.setCvcAddressResult(cvcAddressResult);
                originalTransaction.setApprovalStatus(map.get("approvalStatus"));
                originalTransaction.setResponseDetails(responseDetails);
                originalTransaction.setSelectedInstallment(selectedInstallment);

                Header header = new Header();
                header.setReferences(references);
                header.setRequestId("1234567");


                AuthorizeRequestBase authorizeRequestBase = new AuthorizeRequestBase();
                authorizeRequestBase.setCard(card);
                authorizeRequestBase.setCardHolder(cardHolder);
                authorizeRequestBase.setHeader(header);
                authorizeRequestBase.setMerchant(merchantInfo);
                authorizeRequestBase.setOrder(orderDetails);
                authorizeRequestBase.setPoi(poi);
               // authorizeRequestBase.setMaxWaitTime(Integer.valueOf(map.get("maxWaitTime")));
                authorizeRequestBase.setAuthType( map.get("authType"));
                authorizeRequestBase.setTransaction(transactionDetails);
                authorizeRequestBase.setOriginalTransaction(originalTransaction);
                //authorizeRequestBase.setCompanyName(map.get("companyName"));


                AuthorizeRequestPayload authorizeRequestPayload = new AuthorizeRequestPayload();
                authorizeRequestPayload.setAuthorizeRequestBase(authorizeRequestBase);

              //  String jsonData = objectMapper.writeValueAsString(authorizeRequestPayload);


                //AuthorizeRequestPayload jsonData = gson.toJson(authorizeRequestPayload);
                jsonList.add(authorizeRequestPayload);
            }
            return jsonList;

        }

        private static char detectSeparator(File file) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String firstLine = reader.readLine();
                if (firstLine != null) {
                    // Check if first line contains semicolon or comma
                    if (firstLine.contains(";")) {
                        return ';';
                    } else if (firstLine.contains(",")) {
                        return ',';
                    }
                }
            }
            return ',';
        }


    public void jsonToCsv(JsonNode payload) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(String.valueOf(payload));

        // Flatten JSON
        Map<String, String> flatMap = new HashMap<>();
        flattenJson("", jsonNode, flatMap);

        // Create CSV Schema
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        flatMap.keySet().forEach(csvSchemaBuilder::addColumn);
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        // Write CSV
        CsvMapper csvMapper = new CsvMapper();
        File csvFile = new File("output.csv");
        csvMapper.writerFor(Map.class)
                .with(csvSchema)
                .writeValue(csvFile, flatMap);

        System.out.println("CSV file created: " + csvFile.getAbsolutePath());
    }

    private static void flattenJson(String prefix, JsonNode node, Map<String, String> flatMap) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                flattenJson(prefix + entry.getKey() + ".", entry.getValue(), flatMap);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                flattenJson(prefix + i + ".", node.get(i), flatMap);
            }
        } else {
            flatMap.put(prefix.substring(0, prefix.length() - 1), node.asText());
        }
    }

}







