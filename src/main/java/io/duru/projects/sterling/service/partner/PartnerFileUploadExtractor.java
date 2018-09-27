package io.duru.projects.sterling.service.partner;

import com.google.common.base.Strings;
import io.duru.projects.sterling.apimodel.partner.UploadedPartner;
import io.duru.projects.sterling.model.Location;
import io.duru.projects.sterling.model.Partner;
import io.duru.projects.sterling.model.PartnerProfile;
import io.duru.projects.sterling.model.State;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * created by dduru on 27/09/2018
 */
@Service
public class PartnerFileUploadExtractor {


    public List<UploadedPartner> extractPartners(InputStream inputStream) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        return extractPartnersFromSheet(sheet);
    }


    private List<UploadedPartner> extractPartnersFromSheet(Sheet sheet) {
        List<UploadedPartner> uploadedPartners = new ArrayList<>();

        int rowIndex = 0;

        Row headerRow = sheet.getRow(rowIndex++);
        HashMap<FileHeader, Integer> headerMap = readFileHeaderMap(headerRow);

        String[] rowData;
        Optional<UploadedPartner> uploadedPartner;
        for (Row row = sheet.getRow(rowIndex); row != null; row = sheet.getRow(rowIndex++)) {
            rowData = readRowData(row, headerMap.size());
            uploadedPartner = convertToUploadedPartner(row.getRowNum()+1, rowData, headerMap);

            if (uploadedPartner.isPresent()) {
                uploadedPartners.add(uploadedPartner.get());
            }
        }

        return uploadedPartners;
    }


    private String[] readRowData(Row row, int length) {
        String[] rowData = new String[length];


        Cell cell;
        for (int i = 0, l = rowData.length; i < l; i++) {
            cell = row.getCell(i);
            rowData[i] = cell.getStringCellValue();
        }

        return rowData;
    }


    private Optional<UploadedPartner> convertToUploadedPartner(int lineNumber, String[] rowData, HashMap<FileHeader, Integer> headerMap) {
        if (Strings.isNullOrEmpty(rowData[headerMap.get(FileHeader.NAME)])) {
            return Optional.empty();
        }

        State state = new State();
        state.setName(rowData[headerMap.get(FileHeader.STATE)]);

        Location primaryLocation = new Location();
        primaryLocation.setEmail(rowData[headerMap.get(FileHeader.EMAIL)]);
        primaryLocation.setAddress(rowData[headerMap.get(FileHeader.ADDRESS)]);
        primaryLocation.setPhoneNumber1(rowData[headerMap.get(FileHeader.PHONE_NUMBER_ONE)]);
        primaryLocation.setPhoneNumber2(rowData[headerMap.get(FileHeader.PHONE_NUMBER_TWO)]);

        primaryLocation.setState(state);

        PartnerProfile partnerProfile = new PartnerProfile();
        partnerProfile.setWebsite(rowData[headerMap.get(FileHeader.WEBSITE)]);
        partnerProfile.setFacebookLink(rowData[headerMap.get(FileHeader.FACEBOOK)]);
        partnerProfile.setTwitterLink(rowData[headerMap.get(FileHeader.TWITTER)]);
        partnerProfile.setLinkedInLink(rowData[headerMap.get(FileHeader.LINKEDIN)]);

        Partner partner = new Partner();
        partner.setName(rowData[headerMap.get(FileHeader.NAME)]);
        partner.setPrimaryLocation(primaryLocation);
        partner.setPartnerProfile(partnerProfile);

        return Optional.of(new UploadedPartner(partner, lineNumber));
    }


    private HashMap<FileHeader, Integer> readFileHeaderMap(Row row) {
        HashMap<FileHeader, Integer> headerMap = new HashMap<>();

        Iterator<Cell> cellIterator = row.cellIterator();

        Cell cell;
        String cellValue;

        int index = 0;
        while (cellIterator.hasNext()) {
            cell = cellIterator.next();
            cellValue = cell.getStringCellValue();

            for (FileHeader header : FileHeader.values()) {
                if (cellValue.equalsIgnoreCase(header.getValue())) {
                    headerMap.put(header, index);
                }
            }

            ++index;
        }

        return headerMap;
    }


}

enum FileHeader {

    NAME("NAME"),

    EMAIL("EMAIL"),

    PHONE_NUMBER_ONE("PHONE NUMBER 1"),

    PHONE_NUMBER_TWO("PHONE NUMBER 2"),

    ADDRESS("ADDRESS"),

    STATE("STATE"),

    WEBSITE("WEBSITE"),

    FACEBOOK("FACEBOOK"),

    TWITTER("TWITTER"),

    LINKEDIN("LINKEDIN");


    private String value;


    FileHeader(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }


}