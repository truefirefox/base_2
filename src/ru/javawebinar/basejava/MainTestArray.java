package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.ArrayStorage;

import java.util.Arrays;

public class MainTestArray {

    private static ArrayStorage arrayStorage = new ArrayStorage();

    private static int initSize = 5;

    private static Resume r1 = new Resume();
    private static Resume r2 = new Resume();
    private static Resume r3 = new Resume();
    private static Resume r4 = new Resume();
    private static Resume r5 = new Resume();

    static {
        r1.setUuid("uuid1");
        r2.setUuid("uuid2");
        r3.setUuid("uuid3");
        r4.setUuid("uuid4");
        r5.setUuid("uuid5");
        r1.setFullName("FullName1");
        r2.setFullName("FullName2");
        r3.setFullName("FullName3");
        r4.setFullName("FullName4");
        r5.setFullName("FullName5");
    }

    public static void main(String[] args) {

        testSave();
        testGet();
        testUpdate();
        testDelete();
        testClear();
        testGetAll();
        testSize();

    }

    private static void testSave() {
        fillData();

        Resume resumeForSave = new Resume();
        resumeForSave.setUuid("uuid6");
        arrayStorage.save(resumeForSave);

        for (int i = 1; i <= initSize + 1; i++) {
            if (!arrayStorage.getStorage()[i - 1].getUuid().equals("uuid" + i)) {
                System.out.println("method save contains mistakes");
                break;
            }
        }
        for (int i = initSize + 1; i < arrayStorage.getStorage().length; i++) {
            if (arrayStorage.getStorage()[i] != null) {
                System.out.println("method save contains mistakes");
                break;
            }
        }
        if (arrayStorage.size() != initSize + 1) {
            System.out.println("method save contains mistakes");
        }
    }

    private static void testGet() {
        fillData();

        for (int i = 1; i <= initSize; i++) {
            Resume resume = arrayStorage.get("uuid" + i);

            if (resume == null) {
                System.out.println("method get contains mistakes");
                break;
            }

            if (!resume.getUuid().equals("uuid" + i)) {
                System.out.println("method get contains mistakes");
                break;
            }
        }
        if (arrayStorage.size() != initSize) {
            System.out.println("method get contains mistakes");
        }
    }


    private static void testUpdate() {
        fillData();

        Resume resumeForUpdate = new Resume();
        resumeForUpdate.setUuid("uuid1");
        resumeForUpdate.setFullName("updated");
        arrayStorage.update(resumeForUpdate);

        if (arrayStorage.size() != initSize || arrayStorage.get("uuid1") == null || !arrayStorage.get("uuid1").equals(resumeForUpdate)) {
            System.out.println("method update contains mistakes");
        }
    }

    private static void testDelete() {
        fillData();

        String uuidForDelete = "uuid1";
        arrayStorage.delete(uuidForDelete);
        if (arrayStorage.size() != initSize - 1 || arrayStorage.getStorage()[initSize - 1] != null) {
            System.out.println("method delete contains mistakes");
        }
    }

    private static void testClear() {
        fillData();

        arrayStorage.clear();
        for (Resume resume : arrayStorage.getStorage()) {
            if (resume != null) {
                System.out.println("method clear contains mistakes");
                break;
            }
        }
        if (arrayStorage.size() != 0) {
            System.out.println("method clear contains mistakes");
        }
    }

    private static void testGetAll() {
        fillData();

        Resume[] resumes = new Resume[]{r1, r2, r3, r4, r5};
        if (!Arrays.equals(resumes, arrayStorage.getAll())) {
            System.out.println("method getAll contains mistakes");
        }
    }

    private static void testSize() {
        fillData();

        if (arrayStorage.size() != initSize) {
            System.out.println("method size contains mistakes");
        }
    }

    private static void fillData() {
        arrayStorage = new ArrayStorage();

        arrayStorage.save(r1);
        arrayStorage.save(r2);
        arrayStorage.save(r3);
        arrayStorage.save(r4);
        arrayStorage.save(r5);
    }
}