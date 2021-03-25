package com.epam.jwd.service;

import com.epam.jwd.entity.Massive;

public interface MassiveService {

    int min(Massive massive);

    int max(Massive massive);

    int update(Massive massive, int from, int to, int ... values);
}
