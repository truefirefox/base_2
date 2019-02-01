package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    //todo update
    public void update(Resume resume) {
        //TODO check if resume is present
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        //TODO check if resume is not present & check storage overflow
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        //TODO check if resume is present
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        //TODO check if resume is present
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    /* for testing purpose only */
    public Resume[] getStorage() {
        return storage;
    }
}