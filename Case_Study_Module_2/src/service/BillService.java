package service;

import Repository.BasicCRUD;
import model.Bill;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BillService {
    public static List<Bill> billList;

    static {
        billList = (List<Bill>) SerializationUtil.deserialize(EPath.Bill.getFilePath());
    }

    public BillService() {

    }


}
