package service;

import model.Bill;
import model.BillDetails;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;

public class BillDetailService {
    public static List<BillDetails> billDetailsList;

    static {
        billDetailsList = (List<BillDetails>) SerializationUtil.deserialize(EPath.BILLDETAILS.getFilePath());
    }

    public static void saveBillDetail() {
        SerializationUtil.serialize(billDetailsList, EPath.BILLDETAILS.getFilePath());

    }

    public static void loadBillDetails() {
        SerializationUtil.deserialize(EPath.BILLDETAILS.getFilePath());

    }
}
