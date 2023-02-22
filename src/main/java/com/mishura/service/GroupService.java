package com.mishura.service;

import com.mishura.model.Group;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.GroupRepository;
import com.mishura.repository.SearchableRepository;
import lombok.Getter;


@Getter
public class GroupService implements SearchService{

    private final GeneralRepository<Group> repository;

    //private static final Random RANDOM = new Random();

    private static GroupService instance;

    public GroupService(GeneralRepository<Group> repository) {
        this.repository = repository;
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService(GroupRepository.getInstance());
        }
        return instance;
    }

    public static GroupService getInstance(GeneralRepository<Group> repository) {
        if (instance == null) {
            instance = new GroupService(repository);
        }
        return instance;
    }

    public void getByFieldName(String field, String fieldName) {
        SearchableRepository searchableRepository = (SearchableRepository) getInstance().repository;
        searchableRepository.getByFieldName(field, fieldName);
    }
}

