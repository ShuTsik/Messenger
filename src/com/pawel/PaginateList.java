package com.pawel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PaginateList {
    private static final PaginateList instance = new PaginateList();

    private PaginateList() { };

    public static PaginateList getInstance() {
        return instance;
    }

    public static <T> List<T> paginateList(List<T> list, int paginatedElements) {
        int page = 0;
        int activePage = 1;

        for(int i = 0; i <= list.size(); i++) {
            if(i % 5 == 0) {
                page++;
            }
        }
        System.out.println("Wybierz strone z elementami do wyswietlenia: ");
        System.out.println(activePage + "/" + page);
        Scanner scanner = new Scanner(System.in);
        activePage = scanner.nextInt();
        if(activePage <= 0 || paginatedElements <= 0) {
            throw new IllegalArgumentException();
        }
        int fromIndex = (activePage - 1) * paginatedElements;
        if(list == null || list.size() <= fromIndex) {
            System.out.println("Brak wiadomosci na tej stronie");
            return Collections.emptyList();
        }
        return list.subList(fromIndex, Math.min(fromIndex + paginatedElements, list.size()));
    }

}
