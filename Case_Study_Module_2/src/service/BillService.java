package service;

import model.Bill;
import model.Food;
import model.enums.EPath;
import utils.SerializationUtil;

import java.util.List;

public class BillService implements BasicCRUD {
    public static List<Bill> billList;

    static {
        billList = (List<Bill>) SerializationUtil.deserialize(EPath.Bill.getFilePath());
    }

    @Override
    public Bill getById(int id) {
        return null;
    }
    public Bill getBillById(String id){
        return billList.stream()
                .filter(bill -> bill.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List getAll() {
        return billList;
    }

    @Override
    public void create(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean isExist(int id) {
        return false;
    }

    @Override
    public void print() {

    }
}
