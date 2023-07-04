package utils;

import model.ERoomStatus;
import model.ERoomType;
import model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitData {
    //    public static void init(){
//        if(StudentService.students == null){
//            initStudent();
//        }
//    }
//    private static void initStudent(){
//        Clazz clazz = new Clazz(1L, "C04");
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1L, "Thắng", clazz));
//        StudentService.students = students;
//        SerializationUtil.serialize(students,"data.txt");
//    }
//    private static void initClazz(){
//        Clazz clazz = new Clazz(1L, "C04");
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1L, "Thắng", clazz));
//    }
    public static void init() {

    }
    public static void initRoom(){
        Room room1 = new Room(11,"T1-1", ERoomStatus.available, ERoomType.Normal,30,60000);
        Room room2 = new Room(12,"T1-2", ERoomStatus.available, ERoomType.Student,20,40000);
        Room room3 = new Room(13,"T1-3", ERoomStatus.available, ERoomType.VIP,50,100000);
        Room room4 = new Room(21,"T2-1", ERoomStatus.available, ERoomType.Normal,30,60000);
        Room room5 = new Room(22,"T2-2", ERoomStatus.available, ERoomType.Student,20,40000);
        Room room6 = new Room(23,"T2-3", ERoomStatus.available, ERoomType.VIP,50,100000);

        List<Room> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4, room5, room6));
        SerializationUtil.serialize(rooms,"rooms.txt");


    }
}
