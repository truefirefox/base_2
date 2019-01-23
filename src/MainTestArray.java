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
        r1.uuid = "uuid1";
        r2.uuid = "uuid2";
        r3.uuid = "uuid3";
        r4.uuid = "uuid4";
        r3.uuid = "uuid5";
    }

    public static void main(String[] args) {

        testClear();
        testDelete();
        testSave();
        testGet();
        testGetAll();
        testSize();

    }

    private static void testClear() {
        fillData();
        arrayStorage.clear();
        for (Resume resume : arrayStorage.storage) {
            if (resume != null) {
                System.out.println("method clear contains mistakes");
                break;
            }
        }
        if (arrayStorage.size() != 0) {
            System.out.println("method clear contains mistakes");
        }
    }

    private static void testSave() {
        fillData();
        for (int i = 1; i <= initSize; i++) {
            if (!arrayStorage.storage[i - 1].uuid.equals("uuid" + i)) {
                System.out.println("method save contains mistakes");
                break;
            }
        }
        for (int i = initSize; i < arrayStorage.storage.length; i++) {
            if (arrayStorage.storage[i] != null) {
                System.out.println("method save contains mistakes");
                break;
            }
        }
        if (arrayStorage.size() != initSize + 1) {
            System.out.println("method clear contains mistakes");
        }
    }

    private static void testGet() {
        fillData();
        for (int i = 1; i <= initSize; i++) {
            if (!arrayStorage.get("uuid" + i).uuid.equals("uuid" + i)) {
                System.out.println("method get contains mistakes");
                break;
            }
        }
        if (arrayStorage.size() != initSize) {
            System.out.println("method get contains mistakes");
        }
    }

    private static void testDelete() {
        fillData();
        String uuidForDelete = "uuid1";
        arrayStorage.delete(uuidForDelete);
        if (arrayStorage.size() != initSize - 1 || arrayStorage.get(uuidForDelete) != null || arrayStorage.storage[initSize - 1] != null) {
            System.out.println("method delete contains mistakes");
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