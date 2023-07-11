package service;

import model.Bill;
import model.Food;
import model.enums.EPath;
import utils.AppUtils;
import utils.SerializationUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BillService implements BasicCRUD<Bill> {
    public static List<Bill> billList;

    static {
        billList = (List<Bill>) SerializationUtil.deserialize(EPath.Bill.getFilePath());
    }

    public BillService() {

    }


    @Override
    public Bill getById(int id) {
        return null;
    }

    public Bill getBillId(String id){
        return billList.stream()
                .filter(bill -> bill.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Bill> getAll() {
        return billList;
    }

    @Override
    public void create(Bill bill) {
        billList.add(bill);
        save();
    }
    public static void save() {
        SerializationUtil.serialize(billList, EPath.Bill.getFilePath());
    }

    @Override
    public void update(Bill bill) {
        billList.stream()
                .map(existingFood -> {
                    if (existingFood.getId().equals(bill.getId())) {
                        return bill;
                    } else {
                        return existingFood;
                    }
                })
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(int id) {
        billList = billList.stream()
                .filter(e -> !Objects.equals(e.getId(), id))
                .collect(Collectors.toList());
        save();
    }

    @Override
    public boolean isExist(int id) {
        Bill bill = billList.stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst()
                .orElse(null);
        return bill != null;
    }

    @Override
    public void print() {
        for (Bill bill : billList) {
            System.out.println(bill.toString());
        }
    }
}
